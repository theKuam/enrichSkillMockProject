import com.hainm.apps.enrichskillmockproject.NiaBuildType

plugins {
    alias(libs.plugins.enrichskillmockproject.android.application)
    alias(libs.plugins.enrichskillmockproject.android.application.compose)
    alias(libs.plugins.enrichskillmockproject.android.application.flavors)
    alias(libs.plugins.enrichskillmockproject.android.application.jacoco)
    alias(libs.plugins.enrichskillmockproject.android.hilt)
    id("jacoco")
    alias(libs.plugins.enrichskillmockproject.android.application.firebase)
    id("com.google.android.gms.oss-licenses-plugin")
}

// Load Api key
val apiKeyPropertiesFile = rootProject.file("apikey.properties")
val apiKeyProperties = java.util.Properties()
apiKeyProperties.load(java.io.FileInputStream(apiKeyPropertiesFile))

android {
    defaultConfig {
        applicationId = "com.hainm.apps.enrichskillmockproject"
        minSdk = 27
        targetSdk = 34
        versionCode = 1
        versionName = "1.0.0" // X.Y.Z; X = Major, Y = minor, Z = Patch level

        testInstrumentationRunner = "com.hainm.apps.enrichskillmockproject.core.testing.NiaTestRunner"
        vectorDrawables {
            useSupportLibrary = true
        }

        buildConfigField("String", "API_KEY", apiKeyProperties["API_KEY"])
    }

    buildTypes {
        debug {
            applicationIdSuffix = NiaBuildType.DEBUG.applicationIdSuffix
        }

        val release by getting {
            isMinifyEnabled = true
            applicationIdSuffix = NiaBuildType.RELEASE.applicationIdSuffix
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")

            // To publish on the Play store a private signing key is required, but to allow anyone
            // who clones the code to sign and run the release variant, use the debug signing key.
            // TODO: Abstract the signing configuration to a separate file to avoid hardcoding this.
            signingConfig = signingConfigs.getByName("debug")
        }

        create("benchmark") {
            // Enable all the optimizations from release build through initWith(release).
            initWith(release)
            matchingFallbacks.add("release")
            // Debug key signing is available to everyone.
            signingConfig = signingConfigs.getByName("debug")
            // Only use benchmark proguard rules
            proguardFiles("benchmark-rules.pro")
            isMinifyEnabled = true
            applicationIdSuffix = NiaBuildType.BENCHMARK.applicationIdSuffix
        }
    }
    packaging {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
    namespace = "com.hainm.apps.enrichskillmockproject"
}

dependencies {
    implementation(projects.core.common)
    implementation(projects.core.ui)
    implementation(projects.core.designsystem)
    implementation(projects.core.data)
    implementation(projects.core.model)
    implementation(projects.core.analytics)

    implementation(projects.sync.work)

    androidTestImplementation(projects.core.testing)
    androidTestImplementation(projects.core.datastoreTest)
    androidTestImplementation(projects.core.dataTest)
    androidTestImplementation(projects.core.network)
    androidTestImplementation(libs.androidx.navigation.testing)
    androidTestImplementation(libs.accompanist.testharness)
    //androidTestImplementation(kotlin("test"))
    debugImplementation(libs.androidx.compose.ui.testManifest)
    debugImplementation(projects.uiTestHiltManifest)

    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.core.splashscreen)
    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.lifecycle.runtimeCompose)
    implementation(libs.androidx.compose.runtime.tracing)
    implementation(libs.androidx.compose.material3.windowSizeClass)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.window.manager)
    implementation(libs.androidx.profileinstaller)
    implementation(libs.kotlinx.coroutines.guava)
    implementation(libs.coil.kt)

    // Core functions
    testImplementation(projects.core.testing)
    testImplementation(projects.core.datastoreTest)
    testImplementation(projects.core.dataTest)
    testImplementation(projects.core.network)
    testImplementation(libs.androidx.navigation.testing)
    testImplementation(libs.accompanist.testharness)
    testImplementation(libs.work.testing)
    // testImplementation(kotlin("test"))
    // kaptTest(libs.hilt.compiler)
}
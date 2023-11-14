import java.util.Properties
import com.hainm.enrichskillmockproject.NewsBuildType

plugins {
    alias(libs.plugins.enrichskillmockproject.android.application)
    alias(libs.plugins.enrichskillmockproject.android.application.compose)
    alias(libs.plugins.enrichskillmockproject.android.application.flavors)
    alias(libs.plugins.enrichskillmockproject.android.application.jacoco)
    alias(libs.plugins.enrichskillmockproject.android.hilt)
    id("jacoco")
}

// Load Api key
val apiKeyPropertiesFile = rootProject.file("apikey.properties")
val apiKeyProperties = Properties().apply {
    apiKeyPropertiesFile.inputStream().use { load(it) }
}

android {
    compileSdk = 34

    defaultConfig {
        applicationId = "com.hainm.enrichskillmockproject"
        minSdk = 27
        targetSdk = 34
        versionCode = 1
        versionName = "1.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }

        buildConfigField("String", "API_KEY", apiKeyProperties["API_KEY"].toString())
    }

    buildTypes {
        debug {
            applicationIdSuffix = NewsBuildType.DEBUG.applicationIdSuffix
        }

        val release by getting {
            isMinifyEnabled = true
            applicationIdSuffix = NewsBuildType.RELEASE.applicationIdSuffix
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            signingConfig = signingConfigs.getByName("debug")
        }
    }
    buildFeatures {
        buildConfig = true
    }

    packaging {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
    namespace = "com.hainm.enrichskillmockproject"
}

dependencies {
    // ktx core
    implementation(libs.androidx.core.ktx)
//
//    // lifecycle
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.lifecycle.extensions)

    // compose
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.constraintlayout.compose)

    // navigation
    implementation(libs.androidx.navigation.compose)

    // logging
    implementation(libs.timber)

    // hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
    implementation(libs.androidx.hilt.navigation.compose)

    // retrofit
    implementation(libs.retrofit.core)
    implementation(libs.converter.moshi)
    implementation(libs.moshi.kotlin)

    // Coil
    implementation(libs.coil.kt.compose)

    // accompanist
    implementation(libs.accompanist.systemuicontroller)

    // testing
    testImplementation(libs.junit4)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.test.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.tooling.preview)
}
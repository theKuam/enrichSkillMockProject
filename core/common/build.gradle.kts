plugins {
    alias(libs.plugins.enrichskillmockproject.android.library)
    alias(libs.plugins.enrichskillmockproject.android.library.jacoco)
    alias(libs.plugins.enrichskillmockproject.android.hilt)
}

android {
    namespace = "com.hainm.enrichskillmockproject.core.common"
}

dependencies {
    implementation(libs.kotlinx.coroutines.android)
    testImplementation(projects.core.testing)
}
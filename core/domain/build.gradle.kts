plugins {
    alias(libs.plugins.enrichskillmockproject.android.library)
    alias(libs.plugins.enrichskillmockproject.android.library.jacoco)
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.hainm.enrichskillmockproject.domain"
}

dependencies {
    implementation(projects.core.data)
    implementation(projects.core.model)
    implementation(libs.hilt.android)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.datetime)

    ksp(libs.hilt.compiler)

    testImplementation(projects.core.testing)
}
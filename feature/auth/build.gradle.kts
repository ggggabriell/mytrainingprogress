plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp)
    alias(libs.plugins.kotlin.compose.compiler)
    alias(libs.plugins.google.services)
}

android {
    namespace = "com.mytrainingprogress.auth"
    compileSdk = 35

    defaultConfig {
        minSdk = 30
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation(project(":core:ui"))
    implementation(project(":core:common"))

    // Koin
    implementation(platform(libs.koin.bom))
    implementation(libs.bundles.koin)
    ksp(libs.koin.ksp.compiler)

    // Firebase
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.auth)
    implementation(libs.play.services.auth)
}
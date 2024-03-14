plugins {
    alias(libs.plugins.androidApplication)
}

android {
    namespace = "walkinsilver.example.k_cupjournal"
    compileSdk = 34

    defaultConfig {
        applicationId = "walkinsilver.example.k_cupjournal"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    //The Room persistence library provides an abstraction layer over SQLite
    val room_version  = "2.3.0"
    implementation("androidx.room:room-runtime:$room_version")
    annotationProcessor( "androidx.room:room-compiler:$room_version")

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)
    implementation(libs.activity)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

}
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)

    kotlin("kapt")

    id("com.google.dagger.hilt.android")
    id("androidx.room")

}

android {
    namespace = "com.example.ewallet"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.ewallet"
        minSdk = 33
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.2"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    room {
        schemaDirectory("$projectDir/schemas")
    }
}

dependencies {


    implementation(libs.androidx.core.ktx)

    implementation(libs.androidx.lifecycle.runtime.ktx)

    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.material)
    implementation(libs.androidx.lifecycle.viewmodel)

    implementation(libs.kotlinx.coroutines)

    implementation(libs.coil)

    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)

    implementation(libs.androidx.room.runtime)
    kapt(libs.androidx.room.compiler)
    implementation(libs.androidx.room.coroutines)

    implementation(libs.activityCompat)

    implementation(libs.androidx.navigation.compose)

    implementation(project(":core:common"))
    implementation(project(":core:feature_api"))
    implementation(project(":feature:dashboard:ui"))
    implementation(project(":feature:dashboard:domain"))
    implementation(project(":feature:dashboard:data"))

    implementation(project(":feature:statistics:ui"))
    implementation(project(":feature:statistics:domain"))
    implementation(project(":feature:statistics:data"))

    implementation(project(":feature:payment:ui"))
    implementation(project(":feature:payment:domain"))
    implementation(project(":feature:payment:data"))

    implementation(project(":feature:notification:ui"))
    implementation(project(":feature:notification:domain"))
    implementation(project(":feature:notification:data"))

    implementation(project(":feature:profile:ui"))
    implementation(project(":feature:profile:domain"))
    implementation(project(":feature:profile:data"))

    implementation ("com.google.accompanist:accompanist-insets:0.14.0")

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}
// Allow references to generated code
kapt {
    correctErrorTypes = true
}
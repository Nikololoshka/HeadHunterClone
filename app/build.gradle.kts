plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("kotlin-kapt")
}

android {
    namespace = "com.vereshchagin.nikolay.hh_clone"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.vereshchagin.nikolay.hh_clone"
        minSdk = 24
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
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(project(":core:core_api"))
    implementation(project(":core:core_impl"))
    implementation(project(":core:core_ui"))
    implementation(project(":feature:search_impl"))
    implementation(project(":feature:favorite_impl"))
    implementation(project(":feature:feedback_impl"))
    implementation(project(":feature:message_impl"))
    implementation(project(":feature:profile_impl"))
    implementation(project(":feature:vacancy_detail_api"))
    implementation(project(":feature:vacancy_detail_impl"))
    implementation(project(":module_injector"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    implementation(libs.androidx.navigation.fragment)
    implementation(libs.androidx.navigation.ui)

    implementation (libs.dagger)
    kapt(libs.dagger.compiler)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
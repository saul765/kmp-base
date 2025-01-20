import java.util.Properties

plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.kotlinxSerialization)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kapt)
}

android {
    namespace = "com.example.kmp_base.core"
    compileSdk = 35

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        debug {
            enableUnitTestCoverage = true
        }
        release {
            isMinifyEnabled = false

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}


fun getGradleLocalProperties() = Properties().apply {
    rootProject.file("local.properties").reader().use(::load)
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation(project.dependencies.platform(libs.firebase.android.bom))
    implementation(libs.firebase.android.crashlytics.ktx)
    implementation(libs.firebase.android.analytics.ktx)
    implementation(libs.firebase.android.remote.config.ktx)
    implementation(libs.firebase.android.messaging.ktx)
    implementation(libs.firebase.android.inappmessaging.ktx)
    implementation(libs.ktor.client.okhttp)
    implementation(platform(libs.koin.bom))
    implementation(libs.koin.compose)
    implementation(libs.koin.navigation)
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.ktor.client.okhttp)
    implementation(libs.androidx.material3.icons.extended)
    implementation(libs.compose.material3)
    implementation(libs.lottie)
    implementation(libs.permissions)
    implementation(libs.ktor.serialization.kotlinx.json)

}
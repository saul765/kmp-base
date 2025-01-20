import java.util.Properties

plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kotlinxSerialization)
    alias(libs.plugins.google.services)
    alias(libs.plugins.crashlytics)
    alias(libs.plugins.easyLauncher)
}

@Suppress("UnstableApiUsage")
android {
    namespace = "com.example.kmp_base"
    compileSdk = 35
    defaultConfig {
        applicationId = "com.example.kmp_base"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        named("debug") {
            enableUnitTestCoverage = true
            isDebuggable = true
            firebaseCrashlytics {
                mappingFileUploadEnabled = false
            }
        }
        named("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    flavorDimensions += "server"

    productFlavors {
        /*  TODO UNCOMMENT WHEN SECRET KEY IS SET

        val envSecretKey = System.getenv("SECRET_KEY")
             ?: getGradleLocalProperties().getProperty("SECRET_KEY")

           val formattedKey = "\"$envSecretKey\""

         */


        create("dev") {
            dimension = "server"
            applicationIdSuffix = ".dev"
        }

        create("prod") {
            dimension = "server"
            applicationIdSuffix = ".prod"
        }
    }
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
            isReturnDefaultValues = true
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

easylauncher {
    productFlavors {
        register("dev") {}
    }

    buildTypes {
        register("debug") {
            filters(
                customRibbon(
                    label = "DEV", ribbonColor = "#6600CC", textSizeRatio = 0.2f
                )
            )
        }
        register("release") {}
    }

    variants {

        register("devRelease") {
            filters(
                customRibbon(
                    label = "DEV-QA", ribbonColor = "#6600CC", textSizeRatio = 0.2f
                )
            )
        }
    }
}

fun getGradleLocalProperties() = Properties().apply {
    rootProject.file("local.properties").reader().use(::load)
}

dependencies {
    implementation(project(":core"))
    implementation(projects.shared)
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.compose.material3)
    implementation(libs.androidx.activity.compose)
    debugImplementation(libs.compose.ui.tooling)
    implementation(libs.ktor.serialization.kotlinx.json)
    implementation(project.dependencies.platform(libs.firebase.android.bom))
    implementation(libs.firebase.android.crashlytics.ktx)
    implementation(libs.androidx.splash.screen)
    implementation(libs.koin.android)
    implementation(libs.koin.compose)
    implementation(libs.compose.navigation)
    implementation(libs.lottie)
    implementation(libs.permissions)
    implementation(libs.koin.compose.viewmodel)
    implementation(libs.coil)
    implementation(libs.coil.network)

}
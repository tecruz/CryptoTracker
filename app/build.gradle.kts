import io.gitlab.arturbosch.detekt.Detekt

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.kover)
    alias(libs.plugins.spotless)
    alias(libs.plugins.detekt)
}


android {
    namespace = "com.plcoding.cryptotracker"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.plcoding.cryptotracker"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        debug {
            buildConfigField("String", "BASE_URL", "\"https://api.coincap.io/v2/\"")
        }
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField("String", "BASE_URL", "\"https://api.coincap.io/v2/\"")
        }
    }
    compileOptions {
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        buildConfig = true
        compose = true
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

spotless {
    val buildDirectory = layout.buildDirectory.asFileTree
    kotlin {
        target("**/*.kt")
        targetExclude(buildDirectory)
        ktlint().editorConfigOverride(
            mapOf(
                "indent_size" to "4",
                "continuation_indent_size" to "4",
                "ktlint_function_naming_ignore_when_annotated_with" to "Composable",
                "ktlint_standard_filename" to "disabled",
                "ktlint_standard_package-name" to "disabled"
            )
        )
        licenseHeaderFile(rootProject.file("spotless/spotless.license.kt"))
        trimTrailingWhitespace()
        endWithNewline()
    }
    format("kts") {
        target("**/*.kts")
        targetExclude(buildDirectory)
        licenseHeaderFile(rootProject.file("spotless/spotless.license.kt"), "(^(?![\\/ ]\\*).*$)")
    }
    format("xml") {
        target("**/*.xml")
        targetExclude(buildDirectory)
        licenseHeaderFile(rootProject.file("spotless/spotless.license.xml"), "(<[^!?])")
    }
}

// Kotlin DSL
tasks.withType<Detekt>().configureEach {
    reports {
        html.required.set(true)
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.bundles.compose)
    debugImplementation(libs.bundles.compose.debug)

    coreLibraryDesugaring(libs.desugar.jdk.libs)

    implementation(libs.bundles.koin)

    implementation(libs.bundles.ktor)

    testImplementation(libs.junit)
    testImplementation(libs.turbine)
    testImplementation(libs.assertk)

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
}
plugins {
    id(Plugins.androidApplication)
    id(Plugins.kotlinAndroid)
    id(Plugins.kotlinKapt)
    id(Plugins.navigationSafeArgs)
    id(Plugins.koin)
}

android {
    compileSdkVersion(Configs.compileSdkVersion)

    buildFeatures {
        viewBinding = true
    }

    defaultConfig {
        minSdkVersion(Configs.minSdkVersion)
        targetSdkVersion(Configs.targetSdkVersion)

        applicationId = Configs.applicationId
        versionCode = Configs.versionCode
        versionName = Configs.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables.useSupportLibrary = true
    }

    buildTypes {
        getByName("release") {
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
}

dependencies {
    // Core
    implementation(Libs.kotlinStdLib)
    implementation(Libs.ktxCore)

    // Android
    implementation(Libs.androidAppCompat)
    implementation(Libs.androidMaterial)
    implementation(Libs.androidConstraint)

    // Jetpack LifeCycle
    implementation(Libs.lifecycleRuntime)
    implementation(Libs.lifecycleCommon)
    implementation(Libs.lifecycleViewModel)
    implementation(Libs.lifecycleLiveData)

    // Navigation
    implementation(Libs.androidNavigationFragment)
    implementation(Libs.androidNavigationUi)

    // Koin
    implementation(Libs.koinAndroid)
    implementation(Libs.koinExt)
    implementation(Libs.koinViewModel)
    implementation(Libs.koinScope)

    // Coroutine
    implementation(Libs.coroutines)
    implementation(Libs.coroutinesAndroid)

    // Room
    implementation(Libs.roomRuntime)
    implementation(Libs.roomKtx)
    kapt(Libs.roomCompiler)

    // Log
    implementation(Libs.timber)

    // Test
    testImplementation(Libs.jUnit)
    testImplementation(Libs.coroutineTest)
    androidTestImplementation(Libs.androidExtJUnit)
    androidTestImplementation(Libs.androidEspresso)
}
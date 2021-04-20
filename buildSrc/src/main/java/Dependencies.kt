object Versions {
    const val kotlin = "1.4.31"
    const val ktx = "1.3.2"
    const val gradlePlugin = "4.1.3"
    const val kotlinCoroutines = "1.4.2"
    const val lifecycle = "2.3.1"
    const val androidAppCompat = "1.2.0"
    const val androidMaterial = "1.3.0"
    const val androidConstraint = "2.0.4"
    const val jUnit = "4.12"
    const val androidExtJUnit = "1.1.2"
    const val androidEspresso = "3.3.0"
    const val androidNavigation = "2.3.5"
    const val koin = "2.2.2"
    const val room = "2.2.6"
    const val timber = "4.7.1"
}

object Libs {
    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinCoroutines}"
    const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlinCoroutines}"
    const val coroutineTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.kotlinCoroutines}"
    const val ktxCore = "androidx.core:core-ktx:${Versions.ktx}"
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    const val lifecycleCommon = "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycle}"
    const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val lifecycleLiveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    const val androidAppCompat = "androidx.appcompat:appcompat:${Versions.androidAppCompat}"
    const val androidMaterial = "com.google.android.material:material:${Versions.androidMaterial}"
    const val androidConstraint = "androidx.constraintlayout:constraintlayout:${Versions.androidConstraint}"
    const val jUnit = "junit:junit:${Versions.jUnit}"
    const val androidExtJUnit = "androidx.test.ext:junit:${Versions.androidExtJUnit}"
    const val androidEspresso = "androidx.test.espresso:espresso-core:${Versions.androidEspresso}"
    const val androidNavigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.androidNavigation}"
    const val androidNavigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.androidNavigation}"
    const val koinAndroid = "org.koin:koin-android:${Versions.koin}"
    const val koinViewModel = "org.koin:koin-androidx-viewmodel:${Versions.koin}"
    const val koinScope = "org.koin:koin-androidx-scope:${Versions.koin}"
    const val koinExt = "org.koin:koin-androidx-ext:${Versions.koin}"
    const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
}

object Plugins {
    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinKapt = "kotlin-kapt"
    const val navigationSafeArgs = "androidx.navigation.safeargs.kotlin"
    const val koin = "koin"
}

object ClassPaths {
    const val gradlePlugin = "com.android.tools.build:gradle:${Versions.gradlePlugin}"
    const val kotlinPlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val koinPlugin = "org.koin:koin-gradle-plugin:${Versions.koin}"
    const val navigationSafeArgsPlugin = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.androidNavigation}"
}

object Configs {
    const val applicationId = "com.crazy.memory.game"
    const val compileSdkVersion = 30
    const val minSdkVersion = 21
    const val targetSdkVersion = 30
    const val versionCode = 1
    const val versionName = "1.0.0"
}
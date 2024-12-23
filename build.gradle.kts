
// Top-level build file where you can add configuration options common to all sub-projects/modules.

plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false
    alias(libs.plugins.googleGmsGoogleServices) apply false
    id("com.google.dagger.hilt.android") version "2.48.1" apply false
    id("com.google.devtools.ksp") version "1.9.20-1.0.14" apply false
//    alias(libs.plugins.ksp) apply false
//    alias(libs.plugins.hilt) apply false
//    alias(libs.plugins.dagger) apply false // Hilt plugin
}

dependencies {
//    implementation(libs.plugins.dagger)
}
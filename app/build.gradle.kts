plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.safeArgs)
//    alias(libs.plugins.kept)
}

android {
    namespace = "com.example.sp22_bse_6a_demo"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.sp22_bse_6a_demo"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"  //4.0.0

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

//    kapt {
//        correctErrorTypes = true
//    }

    viewBinding {
        enable = true
    }

    dataBinding {
        enable = true
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
}

dependencies {
    val nav_version = "2.8.3"

    // Jetpack Compose integration
    implementation("androidx.navigation:navigation-compose:$nav_version")

    // Views/Fragments integration
    implementation("androidx.navigation:navigation-fragment:$nav_version")
    implementation("androidx.navigation:navigation-ui:$nav_version")

    // Feature module support for Fragments
    implementation("androidx.navigation:navigation-dynamic-features-fragment:$nav_version")

    // Testing Navigation
    androidTestImplementation("androidx.navigation:navigation-testing:$nav_version")


    //Room Data base

    val room_version = "2.5.0"

    implementation("androidx.room:room-runtime:$room_version")

    // If this project uses any Kotlin source, use Kotlin Symbol Processing (KSP)
    // See Add the KSP plugin to your project
//    ksp("androidx.room:room-compiler:$room_version")
    annotationProcessor("androidx.room:room-compiler:$room_version")
    // For Kotlin
    // If this project only uses Java source, use the Java annotationProcessor
    // No additional plugins are necessary
//    annotationProcessor("androidx.room:room-compiler:$room_version")

    // optional - Kotlin Extensions and Coroutines support for Room
    implementation("androidx.room:room-ktx:$room_version")

    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.8.10")
//    // optional - RxJava2 support for Room
//    implementation("androidx.room:room-rxjava2:$room_version")
//
//    // optional - RxJava3 support for Room
//    implementation("androidx.room:room-rxjava3:$room_version")

//    // optional - Guava support for Room, including Optional and ListenableFuture
//    implementation("androidx.room:room-guava:$room_version")

//    // optional - Test helpers
//    testImplementation("androidx.room:room-testing:$room_version")
//
//    // optional - Paging 3 Integration
//    implementation("androidx.room:room-paging:$room_version")

//    implementation("com.squareup.retrofit2:retrofit:2.1.0") {
//        // exclude Retrofit’s OkHttp dependency module and define your own module import
//        exclude module: "okhttp"
//    }
    implementation("com.google.code.gson:gson:2.6.2")
    implementation("com.squareup.retrofit2:converter-gson:2.1.0")
    implementation("com.squareup.okhttp3:logging-interceptor:3.4.1")
//    implementation("com.squareup.okhttp3:okhttps:3.4.1")
    implementation("com.github.bumptech.glide:glide:4.15.1")
    annotationProcessor("com.github.bumptech.glide:compiler:4.15.1")

//    implementation("com.google.firebase:firebase-messaging:23.0.0")
//    implementation("com.google.firebase:firebase-auth:21.0.1")
//    implementation("com.google.firebase:firebase-database-ktx:20.0.3")
//    implementation("com.google.firebase:firebase-storage-ktx:20.0.0")
//    implementation("com.google.firebase:firebase-firestore:21.4.0")
//    implementation("androidx.recyclerview:recyclerview:1.2.0")

//    implementation("com.firebaseui:firebase-ui-database:5.0.0'
    //Firebase crashlytics
//    implementation platform("com.google.firebase:firebase-bom:29.0.3")
//    implementation("com.google.android.gms:play-services-vision:20.1.3")
//    implementation("com.google.firebase:firebase-core:18.0.3")

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
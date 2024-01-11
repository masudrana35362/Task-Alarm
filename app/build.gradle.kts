plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.masud.task"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.masud.task"
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
}




dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")



    implementation("com.google.firebase:firebase-auth:22.3.0")
    implementation("com.google.firebase:firebase-database:20.3.0")
    implementation("com.google.firebase:firebase-storage:20.3.0")

    implementation ("com.google.android.material:material:1.0.0")

    // ViewModel and LiveData
    implementation ("androidx.lifecycle:lifecycle-extensions:2.1.0")
    // alternatively - just ViewModel
    implementation ("androidx.lifecycle:lifecycle-viewmodel:2.1.0")
    // For Kotlin use lifecycle-viewmodel-ktx
    // alternatively - just LiveData
    implementation ("androidx.lifecycle:lifecycle-livedata:2.1.0")
    // alternatively - Lifecycles only (no ViewModel or LiveData). Some UI
    //     AndroidX libraries use this lightweight import for Lifecycle
    implementation ("androidx.lifecycle:lifecycle-runtime:2.1.0")

    annotationProcessor ("androidx.lifecycle:lifecycle-compiler:2.1.0")
    // For Kotlin use kapt instead of annotationProcessor
    // alternately - if using Java8, use the following instead of lifecycle-compiler
    implementation ("androidx.lifecycle:lifecycle-common-java8:2.1.0")

    // optional - ReactiveStreams support for LiveData
    implementation ("androidx.lifecycle:lifecycle-reactivestreams:2.1.0")
    // For Kotlin use lifecycle-reactivestreams-ktx

    // optional - Test helpers for LiveData
    testImplementation ("androidx.arch.core:core-testing:2.1.0")

    implementation ("it.xabaras.android:recyclerview-swipedecorator:1.4")

    implementation ("androidx.room:room-runtime:2.2.3")
    annotationProcessor ("androidx.room:room-compiler:2.2.3")
    // For Kotlin use kapt instead of annotationProcessor


    // optional - RxJava support for Room
    implementation ("androidx.room:room-rxjava2:2.2.3")

    // optional - Guava support for Room, including Optional and ListenableFuture
    implementation ("androidx.room:room-guava:2.2.3")

    // Test helpers
    testImplementation ("androidx.room:room-testing:2.2.3")

    // swipe decoration
    implementation ("it.xabaras.android:recyclerview-swipedecorator:1.2.2")

    //glide
    implementation ("com.github.bumptech.glide:glide:4.11.0")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.11.0")

    //rate app prompt
    implementation ("com.github.hotchemi:android-rate:1.0.1")

    implementation ("androidx.work:work-runtime-ktx:2.7.1")

}
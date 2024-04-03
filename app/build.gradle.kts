plugins {
    id ("com.android.application")
    id ("org.jetbrains.kotlin.android")
    id ("androidx.navigation.safeargs.kotlin")
    id ("kotlin-kapt")
}


android {
    namespace = "com.ardahangokhan.countries"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.ardahangokhan.countries"
        minSdk = 28
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
    buildFeatures { dataBinding = true
    viewBinding = true}

}


dependencies {

    val lifecycleVersion = "2.6.1"
    val supportVersion = "28.0.0"
    val retrofitVersion = "2.9.0"
    val glideVersion = "4.15.0"
    val roomVersion = "2.6.0"
    val navVersion = "2.7.4"
    val preferencesVersion = "1.2.1"

    implementation ("androidx.core:core-ktx:1.12.0")
    implementation ("androidx.appcompat:appcompat:1.6.1")
    implementation ("com.google.android.material:material:1.11.0")
    implementation ("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.5")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.1")

    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycleVersion")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion")
    //room
    implementation ("androidx.room:room-runtime:$roomVersion")
    implementation ("androidx.legacy:legacy-support-v4:1.0.0")
    implementation ("androidx.room:room-ktx:$roomVersion")
    kapt ("androidx.room:room-compiler:$roomVersion")
    annotationProcessor ("androidx.room:room-compiler:$roomVersion")

    //coroutines for threads
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")

    // navigation
    implementation ("androidx.navigation:navigation-fragment-ktx:$navVersion")
    implementation ("androidx.navigation:navigation-ui-ktx:$navVersion")

    //retrofit
    implementation ("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation ("com.squareup.retrofit2:converter-gson:$retrofitVersion")
    implementation ("com.squareup.retrofit2:adapter-rxjava2:2.9.0")

    //rxJava
    implementation("androidx.room:room-rxjava2:$roomVersion")


    //glide
    implementation ("com.github.bumptech.glide:glide:$glideVersion")

    //noinspection GradleCompatible
    implementation ("com.android.support:palette-v7:$supportVersion")
    implementation ("com.android.support:design:$supportVersion")

    //preference
    implementation ("androidx.preference:preference-ktx:$preferencesVersion")
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath (libs.androidx.navigation.safe.args.gradle.plugin)
    }
}
plugins {
    id ("com.android.application") version ("8.4.1") apply false
    id ("org.jetbrains.kotlin.android") version ("2.0.0-Beta5") apply false
    id ("com.google.devtools.ksp") version ("2.0.0-Beta5-1.0.20") apply false
}
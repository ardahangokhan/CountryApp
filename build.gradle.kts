
buildscript {
    repositories {
        google()
    }
    dependencies {

        val nav_version = "2.7.2"
        classpath ("androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version")
    }
}
plugins {
    id ("com.android.application") version ("8.1.2") apply false
    id ("org.jetbrains.kotlin.android") version ("1.9.0") apply false
    id ("com.google.devtools.ksp") version ("1.8.10-1.0.9") apply false
}
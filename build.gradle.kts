
buildscript {
    repositories {
        google()
    }
    dependencies {

        val nav_version = "2.7.7"
        classpath ("androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version")
    }
}
plugins {
    id ("com.android.application") version ("8.3.1") apply false
    id ("org.jetbrains.kotlin.android") version ("2.0.0-Beta5") apply false
    id ("com.google.devtools.ksp") version ("2.0.0-Beta5-1.0.20") apply false
}
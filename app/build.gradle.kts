plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.appreadstories"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.appreadstories"
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
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)

    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    implementation("mysql:mysql-connector-java:8.0.31")
    implementation("com.squareup.picasso:picasso:2.8")
    implementation("org.jsoup:jsoup:1.16.1")
    implementation ("androidx.sqlite:sqlite:2.1.0")
    implementation(kotlin("script-runtime"))
    implementation ("androidx.constraintlayout:constraintlayout:2.1.4")

}




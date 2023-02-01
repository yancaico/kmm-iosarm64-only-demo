import org.jetbrains.kotlin.gradle.plugin.KotlinCompilation.Companion.MAIN_COMPILATION_NAME

plugins {
    kotlin("multiplatform")
    id("com.android.library")
}

kotlin {
    android()
    iosArm64 {
        binaries {
            framework {  baseName = "shared" }
            all {
                linkerOpts("-framework", "AFramework", "-F${projectDir}/framework/")
            }
        }
        compilations[MAIN_COMPILATION_NAME].cinterops.create("AFramework") {
            defFile("src/nativeInterop/cinterop/AFramework.def")
            compilerOpts("-framework", "AFramework", "-F${projectDir}/framework/")
        }
    }

    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting
        val androidTest by getting
//        val iosX64Main by getting
        val iosArm64Main by getting {
            kotlin.srcDir("src/iosMain/kotlin")
            dependsOn(commonMain)
//            dependencies {  }
        }
//        val iosSimulatorArm64Main by getting
//        val iosMain by creating {
//            dependsOn(commonMain)
////            iosX64Main.dependsOn(this)
//            iosArm64Main.dependsOn(this)
////            iosSimulatorArm64Main.dependsOn(this)
//        }
//        val iosX64Test by getting
        val iosArm64Test by getting {
            dependsOn(commonTest)
        }
//        val iosSimulatorArm64Test by getting
//        val iosTest by creating {
//            dependsOn(commonTest)
////            iosX64Test.dependsOn(this)
//            iosArm64Test.dependsOn(this)
////            iosSimulatorArm64Test.dependsOn(this)
//        }
    }
}

android {
    namespace = "com.example.kmmdemo"
    compileSdk = 32
    defaultConfig {
        minSdk = 21
        targetSdk = 32
    }
}
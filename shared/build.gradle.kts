import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
}

val isRelease = false

val frameworkDir = if(isRelease) "Release-iphoneos" else "Debug-iphoneos"

kotlin {
    android()
//    iosX64()
    iosArm64()
//    iosArm64 {
//        compilations.getByName("main") {
//            val IOTCamera by cinterops.creating {
//                // Path to .def file
//                defFile("src/nativeInterop/cinterop/IOTCamera.def")
//                compilerOpts("-framework", "IOTCamera",
//                    "-F${projectDir}/frameworks/${frameworkDir}/")
//            }
//        }
//
//        binaries.all {
//            // Tell the linker where the framework is located.
//            linkerOpts("-framework", "IOTCamera", "-F${projectDir}/frameworks/${frameworkDir}/")
//        }
//        compilations.getByName("main") {
//            val AnsjerCamera by cinterops.creating {
//                // Path to .def file
//                defFile("src/nativeInterop/cinterop/AnsjerCamera.def")
//                compilerOpts("-framework", "AnsjerCamera",
//                    "-F${projectDir}/frameworks/AnsjerCamera/")
//            }
//        }
//
//        binaries.all {
//            // Tell the linker where the framework is located.
//            linkerOpts("-framework", "AnsjerCamera", "-F${projectDir}/frameworks/AnsjerCamera/")
//        }
//    }
//    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../iosApp/Podfile")
//        extraSpecAttributes.put("vendored_frameworks", "\"frameworks/IOTCamera.framework\"")
        framework {
            baseName = "shared"
        }
        pod("AFNetworking") {
            version = "4.0.1"
        }
//        pod("AnsjerCamera") {
//            version = "1.3.6"
//            source = path(project.file("../AnsjerCamera"))
//        }
//        useLibraries()
    }
//    val iosTarget: (String, KotlinNativeTarget.() -> Unit) -> KotlinNativeTarget =
//        if (System.getenv("SDK_NAME")?.startsWith("iphoneos") == true)
//            ::iosArm64
//        else
//            ::iosArm64
//    iosTarget("ios") {
//        compilations.getByName("main") {
//            val IOTCamera by cinterops.creating {
//                // Path to .def file
//                defFile("src/nativeInterop/cinterop/IOTCamera.def")
//                compilerOpts("-framework", "IOTCamera",
//                    "-F${projectDir}/frameworks/${frameworkDir}/")
//            }
//        }
//
//        binaries {
//            framework {
//                baseName = "shared"
//            }
//            all {
//                linkerOpts("-framework", "IOTCamera", "-F${projectDir}/frameworks/${frameworkDir}/")
//            }
//        }
//    }
    
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

        }
//        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
//            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
//            iosSimulatorArm64Main.dependsOn(this)
        }
//        val iosX64Test by getting
//        val iosArm64Test by getting
//        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
//            iosX64Test.dependsOn(this)
//            iosArm64Test.dependsOn(this)
//            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    namespace = "com.ansjer.kmmdemo"
    compileSdk = 32
    defaultConfig {
        minSdk = 21
        targetSdk = 32
    }
}

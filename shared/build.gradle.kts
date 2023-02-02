import org.jetbrains.kotlin.gradle.plugin.KotlinCompilation
import org.jetbrains.kotlin.gradle.plugin.mpp.BitcodeEmbeddingMode

plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    kotlin("plugin.serialization") version "1.8.0"
    id("com.android.library")
    id("com.squareup.sqldelight")
}

kotlin {
    android()
//    iosX64()
    iosArm64 {
        binaries {
            framework {
                baseName = "shared"
                isStatic = false
            }
            all {
                // Tell the linker where the framework is located.
                linkerOpts("-framework", "AnsjerCamera", "-F${projectDir}/frameworks/","-framework", "IOTCamera", "-F${projectDir}/frameworks/")
            }
        }
        compilations.getByName(KotlinCompilation.MAIN_COMPILATION_NAME) {
            val AnsjerCamera by cinterops.creating {
                // Path to .def file
                defFile("src/nativeInterop/cinterop/AnsjerCamera.def")
                compilerOpts("-framework", "AnsjerCamera", "-F${projectDir}/frameworks/")
            }
            val IOTCamera by cinterops.creating {
                // Path to .def file
                defFile("src/nativeInterop/cinterop/IOTCamera.def")
                compilerOpts("-framework", "IOTCamera", "-F${projectDir}/frameworks/")
            }
        }
    }
//    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "10.0"
        podfile = project.file("../iosApp/Podfile")
        framework {
            isStatic = false
            baseName = "shared"
            embedBitcode(BitcodeEmbeddingMode.DISABLE)
        }
        extraSpecAttributes.put("vendored_frameworks", "'build/cocoapods/framework/shared" +
                ".framework','frameworks/AnsjerCamera.framework','frameworks/IOTCamera.framework'")
//        pod("APodDemo2") {
//            version = "0.1.0"
////            source = git("https://github.com/yancaico/APodDemo.git") {
////                tag = "0.1.0"
////            }
//        }
//        pod("tutk_camera") {
//            version = "1.3.6"
//        }
//        pod("APodDemo2") {
//            version = "0.1.0"
////            source = path(project.file("../APodDemo"))
//        }
//        useLibraries()
    }

    val coroutinesVersion = "1.6.4"
    val ktorVersion = "2.2.1"
    val sqlDelightVersion = "1.5.4"
    val dateTimeVersion = "0.4.0"

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
                implementation("io.ktor:ktor-client-core:$ktorVersion")
                implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
                implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
                implementation("com.squareup.sqldelight:runtime:$sqlDelightVersion")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-android:$ktorVersion")
                implementation("com.squareup.sqldelight:android-driver:$sqlDelightVersion")
            }
        }
        val androidTest by getting
//        val iosX64Main by getting
        val iosArm64Main by getting {
            kotlin.srcDir("src/iosMain/kotlin")
            dependsOn(commonMain)
            dependencies {
                implementation("io.ktor:ktor-client-darwin:$ktorVersion")
                implementation("com.squareup.sqldelight:native-driver:$sqlDelightVersion")
            }
        }
//        val iosSimulatorArm64Main by getting
//        val iosMain by creating {
//            dependsOn(commonMain)
//            dependencies {
//                implementation("io.ktor:ktor-client-darwin:$ktorVersion")
//                implementation("com.squareup.sqldelight:native-driver:$sqlDelightVersion")
//            }
//            iosX64Main.dependsOn(this)
//            iosArm64Main.dependsOn(this)
//            iosSimulatorArm64Main.dependsOn(this)
//        }
//        val iosX64Test by getting
        val iosArm64Test by getting {
            dependsOn(commonTest)
        }
//        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
//            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
//            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    namespace = "com.ansjer.kmmapp"
    compileSdk = 32
    defaultConfig {
        minSdk = 21
        targetSdk = 32
    }
}
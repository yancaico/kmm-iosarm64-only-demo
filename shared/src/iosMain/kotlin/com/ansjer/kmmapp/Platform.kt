package com.ansjer.kmmapp

import platform.UIKit.UIDevice
//import cocoapods.APodDemo2.*
import IOTCamera.*
import AnsjerCamera.*
import IOTCamera.Camera

class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice
        .currentDevice.systemVersion + " " + Person().name() + " " + Camera.getIOTCameraVersion()+ " ;"
}

//fun createAPerson() {
//    val person = APPerson()
//    person.say()
//}
val p = Person()

val camVersion = Camera.getIOTCameraVersion()

actual fun getPlatform(): Platform = IOSPlatform()
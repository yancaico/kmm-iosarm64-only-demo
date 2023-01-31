package com.ansjer.kmmapp

import platform.UIKit.UIDevice
import cocoapods.APodDemo2.*
import IOTCamera.*

class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

fun createAPerson() {
    val person = APPerson()
    person.say()
}

actual fun getPlatform(): Platform = IOSPlatform()
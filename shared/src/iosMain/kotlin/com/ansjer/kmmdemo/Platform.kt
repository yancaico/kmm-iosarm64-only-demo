package com.ansjer.kmmdemo

import platform.UIKit.UIDevice
import IOTCamera.Camera
import cocoapods.AFNetworking.*

class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice
        .currentDevice.systemVersion + " " +AFNetworkReachabilityStatusUnknown
}

actual fun getPlatform(): Platform = IOSPlatform()

actual fun getVersion(): String {
    return Camera.getAVAPIsVersion() ?: "未知"
//    return "Unknown"
}
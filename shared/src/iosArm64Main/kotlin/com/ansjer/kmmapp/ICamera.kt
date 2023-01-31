package com.ansjer.kmmapp
import IOTCamera.Camera as IOTCamera

//actual fun createCamera(cameraInfo: CameraInfo): Camera {
//    return Camera(cameraInfo);
//}

fun auth(licenceKey: String, privateKey: String) {
    IOTCamera.TK_InitIOTCWithLiceseKey(licenceKey, privateKey, {

    },  { error ->b

    });
}
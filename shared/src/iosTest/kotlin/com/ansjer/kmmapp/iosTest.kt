package com.ansjer.kmmapp

import kotlin.test.Test
import kotlin.test.assertTrue

class IosGreetingTest {

    @Test
    fun testExample() {
        assertTrue(Greeting().greet().contains("iOS"), "Check iOS is mentioned")
    }

    @Test
    fun testIOTCamera() {
        val isV = IOTCamera.Camera.getIOTCameraVersion().equals("3.4.4.2")
        assertTrue(isV, "IOTCameraVersion is not 3.4.4.2")
    }
}
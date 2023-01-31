package com.ansjer.kmmapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform

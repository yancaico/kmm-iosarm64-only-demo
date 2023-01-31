package com.ansjer.kmmdemo

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
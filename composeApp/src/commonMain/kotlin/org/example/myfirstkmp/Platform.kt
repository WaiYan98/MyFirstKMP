package org.example.myfirstkmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
package dev.vengateshm.compose.bookapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
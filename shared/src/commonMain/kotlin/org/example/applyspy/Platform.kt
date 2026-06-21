package org.example.applyspy

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
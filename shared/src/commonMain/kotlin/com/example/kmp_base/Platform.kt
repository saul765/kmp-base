package com.example.kmp_base

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
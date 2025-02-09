package com.example.kmp_base.di

import com.example.kmp_base.core.di.CoreModule

object AppModule {

    private val coreModules = CoreModule.coreModules

    private val viewModules = listOf(
        ViewModelsModule.module
    )

    val modules = coreModules + viewModules
}
package com.example.kmp_base.di

import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModules: List<Module>
    get() = AndroidAppModule.platformModules

object AndroidAppModule {
    val appModule = module {
    }


    val platformModules = appModule + listOf()
}
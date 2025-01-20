package com.example.kmp_base.core.di

import com.example.kmp_base.core.utils.coroutines.CoroutineContextProvider
import com.example.kmp_base.core.utils.coroutines.ICoroutineContextProvider
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

object CoroutinesModule {

    val module = module {

        singleOf(::CoroutineContextProvider).bind(ICoroutineContextProvider::class)
    }
}
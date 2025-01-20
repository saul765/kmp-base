package com.example.kmp_base.di

import com.example.kmp_base.json.JsonUtils
import org.koin.dsl.module

object UtilsModule {

    val module = module {

        single { JsonUtils }
    }
}
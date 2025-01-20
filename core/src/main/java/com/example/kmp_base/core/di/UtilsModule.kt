package com.example.kmp_base.core.di

import com.example.kmp_base.core.utils.json.JsonUtils
import org.koin.dsl.module

object UtilsModule {

    val module = module {

        single { JsonUtils }
    }
}
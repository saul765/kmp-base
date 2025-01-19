package com.example.core.di

import com.example.core.utils.json.JsonUtils
import org.koin.dsl.module

object UtilsModule {

    val module = module {

        single { JsonUtils }
    }
}
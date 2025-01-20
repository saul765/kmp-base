package com.example.kmp_base.di

import com.example.kmp_base.webservice.apis.IPokemonApi
import com.example.kmp_base.webservice.apis.PokemonAPI
import com.example.kmp_base.webservice.clients.IPokemonClient
import com.example.kmp_base.webservice.clients.PokemonClient
import kotlinx.serialization.json.Json
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

object WebServiceModule {

    val module = module {

        single {
            Json {
                ignoreUnknownKeys = true
                encodeDefaults = true
                explicitNulls = false
            }
        }


        singleOf(::PokemonClient).bind(IPokemonClient::class)

        singleOf(::PokemonAPI).bind(IPokemonApi::class)
    }
}
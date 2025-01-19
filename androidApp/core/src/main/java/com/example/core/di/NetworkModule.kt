package com.example.core.di

import com.example.composebase.core.network.INetworkMonitor
import com.example.core.network.NetworkMonitor
import io.ktor.client.engine.okhttp.OkHttp
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

object NetworkModule {

    val module = module {

        single { OkHttp.create() }
        singleOf(::NetworkMonitor).bind(INetworkMonitor::class)

    }
}
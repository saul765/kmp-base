package com.example.core.di

import com.example.composebase.core.utils.permissions.IPermissionService
import com.example.composebase.core.utils.permissions.PermissionService
import com.example.core.utils.notifications.INotificationService
import com.example.core.utils.notifications.NotificationService
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

object CoreModule {

    private val coreModule = module {

        singleOf(::NotificationService).bind(INotificationService::class)

        singleOf(::PermissionService).bind(IPermissionService::class)

    }

    private val coroutineModule = listOf(
        CoroutinesModule.module
    )

    private val networkModule = listOf(
        NetworkModule.module
    )

    private val firebaseModule = listOf(
        FirebaseModule.module
    )

    private val utilsModule = listOf(
        UtilsModule.module
    )

    val coreModules = networkModule + coreModule + coroutineModule + firebaseModule + utilsModule
}
package com.example.kmp_base.core.di

import com.example.kmp_base.core.utils.notifications.INotificationService
import com.example.kmp_base.core.utils.notifications.NotificationService
import com.example.kmp_base.core.utils.permissions.IPermissionService
import com.example.kmp_base.core.utils.permissions.PermissionService
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

    val coreModules = networkModule + coreModule + coroutineModule + firebaseModule
}
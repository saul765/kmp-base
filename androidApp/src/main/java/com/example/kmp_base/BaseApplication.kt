package com.example.kmp_base

import android.app.Application
import com.example.kmp_base.di.AppModule
import com.example.kmp_base.di.initKoin
import com.google.firebase.crashlytics.FirebaseCrashlytics
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin()
        setUpCrashlytics()
    }

    private fun setUpCrashlytics() {
        FirebaseCrashlytics.getInstance().isCrashlyticsCollectionEnabled = !BuildConfig.DEBUG
    }

    private fun startKoin() {
        initKoin {
            androidLogger(if (BuildConfig.DEBUG) Level.DEBUG else Level.NONE)
            androidContext(this@BaseApplication)
            modules(AppModule.modules)
        }
    }
}


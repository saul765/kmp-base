package com.example.kmp_base.di

import com.example.kmp_base.MainViewModel
import com.example.kmp_base.feature.home.HomeViewModel
import com.example.kmp_base.feature.search.SearchViewModel
import com.example.kmp_base.feature.settings.SettingsViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

object ViewModelsModule {

    val module = module {

        viewModelOf(::MainViewModel)
        viewModelOf(::HomeViewModel)
        viewModelOf(::SettingsViewModel)
        viewModelOf(::SearchViewModel)

    }
}
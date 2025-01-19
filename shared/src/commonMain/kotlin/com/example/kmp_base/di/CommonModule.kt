package com.example.kmp_base.di

import org.koin.dsl.module

object CommonModule {

    val useCasesModule = module { }


    val sharedModules = useCasesModule + listOf()
}
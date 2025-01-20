package com.example.kmp_base.di

import com.example.kmp_base.usecases.GetHomePokemonUseCase
import com.example.kmp_base.usecases.IGetHomePokemonUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

object UseCasesModule {

    val module = module {

        singleOf(::GetHomePokemonUseCase).bind(IGetHomePokemonUseCase::class)
    }
}
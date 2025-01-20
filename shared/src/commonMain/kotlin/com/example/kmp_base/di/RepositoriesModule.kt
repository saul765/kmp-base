package com.example.kmp_base.di

import com.example.kmp_base.repositories.pokemon.IPokemonDataSource
import com.example.kmp_base.repositories.pokemon.PokemonLocalDataSource
import com.example.kmp_base.repositories.pokemon.PokemonRemoteDataSource
import com.example.kmp_base.repositories.pokemon.PokemonRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

object RepositoriesModule {

    val module = module {

        singleOf(::PokemonRepository).bind(IPokemonDataSource.Repository::class)

        singleOf(::PokemonRemoteDataSource).bind(IPokemonDataSource.Remote::class)

        singleOf(::PokemonLocalDataSource).bind(IPokemonDataSource.Local::class)

    }
}
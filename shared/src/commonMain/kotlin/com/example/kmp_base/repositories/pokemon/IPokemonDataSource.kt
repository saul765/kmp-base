package com.example.kmp_base.repositories.pokemon

import com.example.kmp_base.model.PokemonItem
import com.example.composebase.core.model.PokemonResult
import com.example.kmp_base.webservice.dto.responses.PokemonItemDTO
import com.example.kmp_base.webservice.dto.responses.PokemonResultDTO

interface IPokemonDataSource {

    interface Remote {
        suspend fun getPokemons(limit: Int, offset: Int): PokemonResultDTO

        suspend fun getPokemonDetail(pokemonUrl: String): PokemonItemDTO
    }

    interface Local {}

    interface Repository {
        suspend fun getPokemonsAsync(limit: Int, offset: Int): PokemonResult

        suspend fun getPokemonDetailAsync(pokemonUrl: String): PokemonItem

    }
}
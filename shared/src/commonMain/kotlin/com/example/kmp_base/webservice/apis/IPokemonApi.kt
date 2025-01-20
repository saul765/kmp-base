package com.example.kmp_base.webservice.apis

import com.example.kmp_base.webservice.dto.responses.PokemonItemDTO
import com.example.kmp_base.webservice.dto.responses.PokemonResultDTO

interface IPokemonApi {

    suspend fun getPokemons(limit: Int, offset: Int): PokemonResultDTO

    suspend fun getPokemonDetail(pokemonUrl: String): PokemonItemDTO
}
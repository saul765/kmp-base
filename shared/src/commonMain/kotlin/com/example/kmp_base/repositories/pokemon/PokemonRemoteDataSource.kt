package com.example.kmp_base.repositories.pokemon

import com.example.kmp_base.webservice.apis.IPokemonApi
import com.example.kmp_base.webservice.dto.responses.PokemonItemDTO
import com.example.kmp_base.webservice.dto.responses.PokemonResultDTO
import com.example.kmp_base.repositories.pokemon.IPokemonDataSource

class PokemonRemoteDataSource(private val pokemonApi: IPokemonApi) : IPokemonDataSource.Remote {

    override suspend fun getPokemons(limit: Int, offset: Int): PokemonResultDTO =
        pokemonApi.getPokemons(limit, offset)

    override suspend fun getPokemonDetail(pokemonUrl: String): PokemonItemDTO =
        pokemonApi.getPokemonDetail(pokemonUrl)

}
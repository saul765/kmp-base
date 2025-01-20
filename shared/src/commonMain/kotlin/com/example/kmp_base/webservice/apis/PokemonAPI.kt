package com.example.kmp_base.webservice.apis

import com.example.kmp_base.webservice.clients.IPokemonClient
import com.example.kmp_base.webservice.dto.responses.PokemonItemDTO
import com.example.kmp_base.webservice.dto.responses.PokemonResultDTO
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.request
import io.ktor.http.HttpMethod
import io.ktor.http.encodedPath

class PokemonAPI(
    pokemonClient: IPokemonClient
) : IPokemonApi {


    companion object {
        //Params
        const val LIMIT_PARAM = "limit"
        const val OFFSET_PARAM = "offset"

        //Endpoints
        const val GET_POKEMONS = "pokemon"

    }

    private val client = pokemonClient.client

    override suspend fun getPokemons(limit: Int, offset: Int): PokemonResultDTO = client.request {

        method = HttpMethod.Get
        url {
            encodedPath = GET_POKEMONS
            parameters[LIMIT_PARAM] = limit.toString()
            parameters[OFFSET_PARAM] = offset.toString()
        }
    }.body()

    override suspend fun getPokemonDetail(pokemonUrl: String): PokemonItemDTO =
        client.get(pokemonUrl).body()
}
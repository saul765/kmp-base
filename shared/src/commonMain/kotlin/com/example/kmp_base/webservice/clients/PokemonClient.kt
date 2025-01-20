package com.example.kmp_base.webservice.clients

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class PokemonClient(
    private val json: Json,
    engine: HttpClientEngine
) : IPokemonClient {

    companion object {
        const val BASE_URL = "https://pokeapi.co/api/v2/"
    }

    override val client: HttpClient = HttpClient(engine) {
        install(ContentNegotiation) {
            json(json)
        }

        install(DefaultRequest) {
            header(HttpHeaders.ContentType, ContentType.Application.Json)

            url(BASE_URL)
        }
    }
}
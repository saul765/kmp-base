package com.example.kmp_base.webservice.clients

import io.ktor.client.HttpClient

interface IPokemonClient {
    val client: HttpClient
}
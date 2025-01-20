package com.example.kmp_base.usecases

import com.example.kmp_base.model.PokemonItem
import com.example.kmp_base.repositories.pokemon.IPokemonDataSource
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface IGetHomePokemonUseCase {
    suspend fun execute(): Flow<List<PokemonItem>>
}

class GetHomePokemonUseCase(
    private val pokemonRepository: IPokemonDataSource.Repository,
) : IGetHomePokemonUseCase {
    companion object {
        const val POKEMON_FIRST_CHUNK = 15
        const val POKEMON_OFFSET = 0
    }

    override suspend fun execute(): Flow<List<PokemonItem>> = flow {

        val pokemonResult =
            pokemonRepository.getPokemonsAsync(POKEMON_FIRST_CHUNK, POKEMON_OFFSET)

        val pokemonItems = coroutineScope {
            pokemonResult.results.map { pokemon ->
                async { pokemonRepository.getPokemonDetailAsync(pokemon.url) }
            }.awaitAll()
        }

        emit(pokemonItems)

    }
}

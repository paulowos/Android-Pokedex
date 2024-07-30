package com.example.androidpokedex.repository

import com.example.androidpokedex.data.network.PokeApi
import com.example.androidpokedex.data.network.responses.Pokemon
import com.example.androidpokedex.data.network.responses.PokemonList
import com.example.androidpokedex.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PokemonRepository
    @Inject
    constructor(
        private val api: PokeApi,
    ) : IPokemonRepository {
        override suspend fun getPokemonList(
            limit: Int,
            offset: Int,
        ): Resource<PokemonList> =
            try {
                Resource.Success(api.getPokemonList(limit, offset))
            } catch (e: Exception) {
                Resource.Error("A error occurred")
            }

        override suspend fun getPokemonDetail(pokemonName: String): Resource<Pokemon> =
            try {
                Resource.Success(api.getPokemonDetail(pokemonName))
            } catch (e: Exception) {
                Resource.Error("A error occurred")
            }
    }

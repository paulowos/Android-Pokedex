package com.example.androidpokedex.repository

import com.example.androidpokedex.data.network.PokeApi
import com.example.androidpokedex.data.network.responses.PokemonList
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
        ): PokemonList {
            try {
                val response = api.getPokemonList(limit, offset)
            } catch (e: Exception) {
            }
        }
    }

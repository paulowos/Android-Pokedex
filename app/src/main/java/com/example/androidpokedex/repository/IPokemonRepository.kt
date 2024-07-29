package com.example.androidpokedex.repository

import com.example.androidpokedex.data.network.responses.PokemonList

interface IPokemonRepository {
    suspend fun getPokemonList(
        limit: Int,
        offset: Int,
    ): PokemonList
}

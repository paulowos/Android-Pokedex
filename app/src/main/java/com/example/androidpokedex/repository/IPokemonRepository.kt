package com.example.androidpokedex.repository

import com.example.androidpokedex.data.network.responses.Pokemon
import com.example.androidpokedex.data.network.responses.PokemonList
import com.example.androidpokedex.util.Resource

interface IPokemonRepository {
    suspend fun getPokemonList(
        limit: Int,
        offset: Int,
    ): Resource<PokemonList>

    suspend fun getPokemonDetail(pokemonName: String): Resource<Pokemon>
}

package com.example.androidpokedex.data.network

import com.example.androidpokedex.data.network.responses.Pokemon
import com.example.androidpokedex.data.network.responses.PokemonList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeApi {
    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int = 20,
        @Query("offset") offset: Int = 0,
    ): PokemonList

    @GET("pokemon/{pokemonName}")
    suspend fun getPokemonDetail(
        @Path("pokemonName") pokemonName: String,
    ): Pokemon
}

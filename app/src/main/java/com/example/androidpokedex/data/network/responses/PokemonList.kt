package com.example.androidpokedex.data.network.responses

data class PokemonList(
    val count: Int,
    val next: String,
    val previous: String?,
    val results: List<Result>,
) {
    data class Result(
        val name: String,
        val url: String,
    )
}

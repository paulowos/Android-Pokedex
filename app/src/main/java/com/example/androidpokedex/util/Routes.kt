package com.example.androidpokedex.util

object Routes {
    val pokemonListScreen = "pokemon_list_screen"

    fun pokemonDetailScreen(
        dominantColor: Int = 0,
        pokemonName: String = "",
        baseUrl: Boolean = false,
    ): String {
        if (baseUrl) {
            return "pokemon_detail_screen/{dominantColor}/{pokemonName}"
        }
        return "pokemon_detail_screen/$dominantColor/$pokemonName"
    }
}

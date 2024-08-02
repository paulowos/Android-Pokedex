package com.example.androidpokedex.ui.component

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.androidpokedex.data.network.responses.Pokemon
import com.example.androidpokedex.util.Resource

@Composable
fun PokemonDetailStateWrapper(
    modifier: Modifier = Modifier,
    loadingModifier: Modifier = Modifier,
    pokemonDetail: Resource<Pokemon>
) {
    when (pokemonDetail) {
        is Resource.Error -> Text(
            text = pokemonDetail.message!!,
            color = Color.Red,
            modifier = modifier
        )

        is Resource.Loading -> CircularProgressIndicator(
            color = MaterialTheme.colorScheme.surfaceVariant,
            modifier = loadingModifier
        )

        is Resource.Success -> {
            PokemonDetailSection(pokemonDetail = pokemonDetail.data!!, modifier = modifier)
        }
    }
}
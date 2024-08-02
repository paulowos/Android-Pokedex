package com.example.androidpokedex.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.androidpokedex.data.network.responses.Pokemon
import java.util.Locale

@Composable
fun PokemonDetailSection(modifier: Modifier = Modifier, pokemonDetail: Pokemon) {
    val scrollState = rememberScrollState()
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        Text(
            text = "#${pokemonDetail.id} ${
                pokemonDetail.name.replaceFirstChar {
                    if (it.isLowerCase()) it.titlecase(
                        Locale.ROOT
                    ) else it.toString()
                }
            }",
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onSurface,
            fontSize = 22.sp
        )
        PokemonTypeSection(types = pokemonDetail.types)
        PokemonDetailDataSection(
            pokemonHeight = pokemonDetail.height,
            pokemonWeight = pokemonDetail.weight
        )
    }

}

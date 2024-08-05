package com.example.androidpokedex.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidpokedex.data.network.responses.Pokemon
import com.example.androidpokedex.util.PokemonParse

@Composable
fun PokemonBaseStats(
    pokemonDetail: Pokemon,
    animationDelayPerItem: Int = 100,
) {
    val maxStat = remember {
        pokemonDetail.stats.maxOf { it.baseStat }
    }

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(horizontal = 16.dp)
            .padding(top = 5.dp)
    ) {
        Text(
            text = "Base Stats",
            fontSize = 20.sp,
            color = MaterialTheme.colorScheme.onSurface,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.height(10.dp))

        pokemonDetail.stats.forEachIndexed { index, stat ->
            PokemonStat(
                statName = PokemonParse.statToAbbr(stat),
                statValue = stat.baseStat,
                statMaxValue = maxStat,
                statColor = PokemonParse.statToColor(stat),
                animationDelay = index * animationDelayPerItem
            )
            Spacer(modifier = Modifier.height(8.dp))
        }

    }
}
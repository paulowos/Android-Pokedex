package com.example.androidpokedex.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.androidpokedex.data.model.PokedexEntryModel
import com.example.androidpokedex.ui.theme.RobotoCondensed
import com.example.androidpokedex.ui.viewModel.PokemonListViewModel
import com.example.androidpokedex.util.Routes

@Composable
fun PokedexEntry(
    entry: PokedexEntryModel,
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: PokemonListViewModel = hiltViewModel(),
) {
    val defaultDominantColor = MaterialTheme.colorScheme.surface
    var dominantColor by
        remember {
            mutableStateOf(defaultDominantColor)
        }
    Box(
        contentAlignment = Center,
        modifier =
            modifier
                .shadow(5.dp, RoundedCornerShape(10.dp))
                .clip(RoundedCornerShape(10.dp))
                .aspectRatio(1f)
                .background(
                    Brush.verticalGradient(
                        listOf(dominantColor, defaultDominantColor),
                    ),
                ).clickable {
                    navController.navigate(
                        Routes.pokemonDetailScreen(
                            dominantColor.toArgb(),
                            entry.pokemonName,
                        ),
                    )
                },
    ) {
        Column {
            AsyncImage(
                model =
                    ImageRequest
                        .Builder(LocalContext.current)
                        .data(entry.imageUrl)
                        .target {
                            viewModel.calcDominantColor(it) { color ->
                                dominantColor = color
                            }
                        }.build(),
                contentDescription = entry.pokemonName,
                modifier = Modifier.size(120.dp).align(CenterHorizontally),
            )
            Text(
                text = entry.pokemonName,
                fontFamily = RobotoCondensed,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
            )
//
        }
    }
}

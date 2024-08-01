package com.example.androidpokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.androidpokedex.ui.screen.PokemonDetailScreen
import com.example.androidpokedex.ui.screen.PokemonListScreen
import com.example.androidpokedex.ui.theme.AndroidPokedexTheme
import com.example.androidpokedex.util.Routes
import dagger.hilt.android.AndroidEntryPoint
import java.util.Locale

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidPokedexTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Routes.pokemonListScreen,
                ) {
                    composable(Routes.pokemonListScreen) {
                        PokemonListScreen(navController)
                    }
                    composable(
                        Routes.pokemonDetailScreen(baseUrl = true),
                        arguments =
                        listOf(
                            navArgument("dominantColor") {
                                type = NavType.IntType
                            },
                            navArgument("pokemonName") {
                                type = NavType.StringType
                            },
                        ),
                    ) {
                        val dominantColor = remember {
                            val color = it.arguments?.getInt("dominantColor")
                            color?.let { Color(it) } ?: Color.White
                        }

                        val pokemonName = remember {
                            it.arguments?.getString("pokemonName") ?: ""
                        }.lowercase(Locale.ROOT)
                        PokemonDetailScreen(
                            dominantColor = dominantColor,
                            pokemonName = pokemonName,
                            navController = navController
                        )
                    }
                }
            }
        }
    }
}

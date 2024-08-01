package com.example.androidpokedex.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.androidpokedex.R
import com.example.androidpokedex.ui.component.PokemonList
import com.example.androidpokedex.ui.component.SearchBar
import com.example.androidpokedex.ui.viewModel.PokemonListViewModel

@Composable
fun PokemonListScreen(
    navController: NavController,
    viewModel: PokemonListViewModel = hiltViewModel(),
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .safeDrawingPadding()
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Image(
            painter = painterResource(id = R.drawable.ic_international_pok_mon_logo),
            contentDescription = "Pokemon",
            modifier = Modifier
                .fillMaxWidth()
                .align(CenterHorizontally),
        )
        SearchBar(
            hint = "Search ...",
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
        ) {
            viewModel.searchPokemonList(it)
        }
        Spacer(modifier = Modifier.height(16.dp))
        PokemonList(navController = navController)
    }
}

package com.example.androidpokedex.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.androidpokedex.R
import com.example.androidpokedex.ui.composable.SearchBar

@Composable
fun PokemonListScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(20.dp))
        Image(
            painter = painterResource(id = R.drawable.ic_international_pok_mon_logo),
            contentDescription = "Pokemon",
            modifier =
                Modifier
                    .fillMaxWidth()
                    .align(CenterHorizontally),
        )
        SearchBar(
            hint = "Search ...",
            modifier = Modifier.fillMaxWidth().padding(16.dp),
        )
    }
}

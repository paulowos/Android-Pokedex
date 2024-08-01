package com.example.androidpokedex.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun PokemonDetailTopSection(navController: NavController) {
    Icon(
        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
        contentDescription = "Return",
        tint = MaterialTheme.colorScheme.inverseSurface,
        modifier = Modifier
            .size(36.dp)
            .offset(16.dp, 16.dp)
            .clickable { navController.popBackStack() }
    )
}
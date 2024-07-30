package com.example.androidpokedex.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.androidpokedex.data.model.PokedexEntryModel

@Composable
fun PokedexRow(
    rowIndex: Int,
    entries: List<PokedexEntryModel>,
    navController: NavController,
) {
    Column {
        Row {
            PokedexEntry(entry = entries[rowIndex * 2], navController = navController, modifier = Modifier)
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}

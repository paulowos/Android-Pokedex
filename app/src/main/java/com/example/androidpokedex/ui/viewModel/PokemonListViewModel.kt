package com.example.androidpokedex.ui.viewModel

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.palette.graphics.Palette
import com.example.androidpokedex.repository.IPokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel
    @Inject
    constructor(
        private val repository: IPokemonRepository,
    ) : ViewModel() {
        fun calcDominantColor(
            drawable: Drawable,
            onFinish: (color: Color) -> Unit,
        ) {
            val bmp = (drawable as BitmapDrawable).bitmap.copy(Bitmap.Config.ARGB_8888, true)
            Palette.from(bmp).generate {
                it?.dominantSwatch?.rgb?.let { color ->
                    onFinish(Color(color))
                }
            }
        }
    }

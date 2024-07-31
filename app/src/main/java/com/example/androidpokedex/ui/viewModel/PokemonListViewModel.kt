package com.example.androidpokedex.ui.viewModel

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.palette.graphics.Palette
import com.example.androidpokedex.data.model.PokedexEntryModel
import com.example.androidpokedex.repository.IPokemonRepository
import com.example.androidpokedex.util.Constants.PAGE_SIZE
import com.example.androidpokedex.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel
    @Inject
    constructor(
        private val repository: IPokemonRepository,
    ) : ViewModel() {
        private var currentPage = 0

        var pokemonList = mutableStateOf<List<PokedexEntryModel>>(listOf())
        var loadError = mutableStateOf("")
        var isLoading = mutableStateOf(false)
        var isEndReached = mutableStateOf(false)

        init {
            getPokemonPaginated()
        }

        fun getPokemonPaginated() {
            viewModelScope.launch {
                isLoading.value = true
                when (val result = repository.getPokemonList(PAGE_SIZE, currentPage * PAGE_SIZE)) {
                    is Resource.Error -> {
                        loadError.value = result.message!!
                        isLoading.value = false
                    }
                    is Resource.Success -> {
                        isEndReached.value = currentPage * PAGE_SIZE >= result.data!!.count
                        val pokedexEntries =
                            result.data.results.map { entry ->
                                val number =
                                    if (entry.url.endsWith("/")) {
                                        entry.url.dropLast(1).takeLastWhile { it.isDigit() }
                                    } else {
                                        entry.url.takeLastWhile { it.isDigit() }
                                    }
                                val url = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$number.png"
                                PokedexEntryModel(entry.name.capitalize(Locale.current), url, number.toInt())
                            }
                        currentPage += 1
                        loadError.value = ""
                        isLoading.value = false
                        pokemonList.value += pokedexEntries
                    }
                }
            }
        }

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

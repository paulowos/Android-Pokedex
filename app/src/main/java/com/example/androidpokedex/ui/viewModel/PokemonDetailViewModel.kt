package com.example.androidpokedex.ui.viewModel

import androidx.lifecycle.ViewModel
import com.example.androidpokedex.data.network.responses.Pokemon
import com.example.androidpokedex.repository.IPokemonRepository
import com.example.androidpokedex.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val repository: IPokemonRepository
) : ViewModel() {
    suspend fun getPokemonDetail(pokemonName: String): Resource<Pokemon> {
        return repository.getPokemonDetail(pokemonName)
    }
}
package com.alanturing.pokeapp2627.features.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alanturing.pokeapp2627.features.pokemon.data.model.Pokemon
import com.alanturing.pokeapp2627.features.pokemon.data.repository.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val _repository: PokemonRepository
) : ViewModel() {

    var pokemons by mutableStateOf<List<Pokemon>>(emptyList())
        private set

    init {
        viewModelScope.launch {
            pokemons = _repository.readAllPokemon() ?: emptyList()
        }
    }
}
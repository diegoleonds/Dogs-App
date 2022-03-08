package com.example.dogsapp.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dogsapp.data.repository.BreedRepository
import com.example.dogsapp.ui.activity.BreedsListUiState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class BreedsListViewModel(
    private val repository: BreedRepository
): ViewModel() {
    var uiState by mutableStateOf(BreedsListUiState())
        private set

    fun fetchBreeds() {
        uiState = uiState.copy(isLoading = true)
        viewModelScope.launch {
            val breeds = repository.getBreeds()
            uiState = uiState.copy(breeds = breeds, isLoading = false)
        }
    }
}
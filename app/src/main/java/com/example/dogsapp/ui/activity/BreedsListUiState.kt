package com.example.dogsapp.ui.activity

import com.example.dogsapp.data.model.Breed

data class BreedsListUiState(
    val breeds: List<Breed> = emptyList(),
    val isLoading: Boolean = false
)
package com.example.dogsapp.ui.di

import com.example.dogsapp.data.repository.BreedRepositoryImpl
import com.example.dogsapp.ui.viewmodel.BreedsListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {
    viewModel { BreedsListViewModel(get<BreedRepositoryImpl>()) }
}
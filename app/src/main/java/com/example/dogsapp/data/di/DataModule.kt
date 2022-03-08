package com.example.dogsapp.data.di

import com.example.dogsapp.data.api.Retrofit
import com.example.dogsapp.data.datasource.RemoteBreedDataSource
import com.example.dogsapp.data.repository.BreedRepositoryImpl
import org.koin.dsl.module

val dataModule = module {
    single { BreedRepositoryImpl(get<RemoteBreedDataSource>()) }
    factory { RemoteBreedDataSource(Retrofit.api) }
}
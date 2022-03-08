package com.example.dogsapp.data.repository

import com.example.dogsapp.data.datasource.BreedDataSource
import com.example.dogsapp.data.model.Breed

interface BreedRepository {
    suspend fun getBreeds(): List<Breed>
    suspend fun getBreedImgUrl(breed: Breed): String
}

class BreedRepositoryImpl(
    private val dataSource: BreedDataSource
): BreedRepository {
    override suspend fun getBreeds() = dataSource.getBreeds()
    override suspend fun getBreedImgUrl(breed: Breed) = ""
}
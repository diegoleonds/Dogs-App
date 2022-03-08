package com.example.dogsapp.data.datasource

import com.example.dogsapp.data.api.BreedApi
import com.example.dogsapp.data.model.Breed

interface BreedDataSource {
    suspend fun getBreeds(): List<Breed>
}

class RemoteBreedDataSource(
    private val breedApi: BreedApi
): BreedDataSource {
    override suspend fun getBreeds(): List<Breed> {
        val breedsJson = breedApi.getBreeds()["message"] as Map<String, List<String>?>
        val breeds = ArrayList<Breed>()

        breedsJson.forEach { breedInfo ->
            breeds.add(transformMapIntoBreed(breedInfo))
        }

        return breeds
    }

    private fun transformMapIntoBreed(map: Map.Entry<String, List<String>?>): Breed {
        return Breed(
            map.key,
            map.value ?: emptyList()
        )
    }
}
package com.example.dogsapp.data.api

import org.json.JSONObject
import retrofit2.http.GET

interface BreedApi {
    @GET("breeds/list/all")
    suspend fun getBreeds(): Map<String, Any>

    @GET("")
    suspend fun getBreedImgUrl(): String
}
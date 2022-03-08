package com.example.dogsapp.data.datasource

import com.example.dogsapp.data.api.BreedApi
import com.example.dogsapp.data.model.Breed
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotSame

import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class RemoteBreedDataSourceTest {
    private val api = mockk<BreedApi>()
    private val response = LinkedHashMap<String, Any>()
    private val responseBreeds = LinkedHashMap<String, List<String>>()

    private val dataSource = RemoteBreedDataSource(api)

    @Before
    fun initTest() {
        responseBreeds["doge"] = emptyList()
        responseBreeds["australian"] = listOf("shepherd")
        responseBreeds["bulldog"] = listOf("boston",
            "english",
            "french"
        )
        response["message"] = responseBreeds

        coEvery { api.getBreeds() } returns response
    }

    @Test
    fun shouldGetBreeds() = runBlocking {
        val expectedBreeds = listOf(
            Breed("doge"),
            Breed(
                "australian",
                listOf("shepherd")
            ),
            Breed(
                "bulldog",
                listOf("boston",
                    "english",
                    "french"
                )
            )
        )
        val notExpectedBreeds = ArrayList(expectedBreeds).add(
            Breed(
                "Not expecting this one"
            )
        )
        val dataSourceBreeds = dataSource.getBreeds()

        assertEquals(expectedBreeds, dataSourceBreeds)
        assertNotSame(notExpectedBreeds, dataSourceBreeds)
    }
}


























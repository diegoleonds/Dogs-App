package com.example.dogsapp.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.dogsapp.data.model.Breed
import com.example.dogsapp.ui.composable.SimpleListItem
import com.example.dogsapp.ui.theme.DogsAppTheme
import com.example.dogsapp.ui.viewmodel.BreedsListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class BreedsListActivity : ComponentActivity() {
    private val viewModel: BreedsListViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DogsApp(viewModel)
        }
        viewModel.fetchBreeds()
    }

    @Composable
    fun DogsApp(viewModel: BreedsListViewModel) {
        DogsAppTheme {
            Scaffold {
                val uiState = viewModel.uiState
                if (uiState.isLoading) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        CircularProgressIndicator()
                    }
                } else {
                    BreedsList(uiState.breeds)
                }
            }
        }
    }

    @Composable
    fun BreedsList(breeds: List<Breed>) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            items(breeds) { breed ->
                SimpleListItem(
                    name = breed.name,
                    modifier = Modifier.clickable { }
                )
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {

    }
}
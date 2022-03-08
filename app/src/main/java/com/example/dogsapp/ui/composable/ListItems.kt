package com.example.dogsapp.ui.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SimpleListItem(name: String, modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier)
    ) {
        Text(
            text = name,
            fontSize = 20.sp,
            modifier = Modifier
                .padding(horizontal = 5.dp, vertical = 5.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SimpleListItem(name = "Test")
}
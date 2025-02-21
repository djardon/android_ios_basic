package com.ds.dscompose.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview(
    name = "Sample Preview Lazy Components",
    showBackground = true,
    widthDp = 320,
    heightDp = 640
)
@Composable
fun LazyComponents() {
    Column {
        LazyRowComponents()
        LazyColumnComponents()
    }
}

@Composable
private fun LazyColumnComponents() {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(100) { index ->
            Log.i("LazyColumnComponents", "Column Item $index")
            Text(
                text = "Item $index",
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray)
                    .padding(16.dp),
                fontSize = 18.sp
            )
        }
    }
}

@Composable
private fun LazyRowComponents() {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(100) { index ->
            Log.i("LazyRowComponents", "Row Item $index")
            Text(
                text = "Item $index",
                modifier = Modifier
                    .background(Color.Cyan)
                    .padding(16.dp),
                fontSize = 18.sp
            )
        }
    }
}
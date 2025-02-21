package com.ds.kmmproject.presentation.list

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.ds.kmmproject.domain.models.Museum
import com.ds.kmmproject.presentation.empty.EmptyScreenContent
import org.koin.androidx.compose.koinViewModel

@Composable
fun ListScreen(
    navigateToDetails: (objectId: Long) -> Unit,
    listViewModel: ListViewModel = koinViewModel<ListViewModel>()
) {
    val museums by listViewModel.museums.collectAsState()

    AnimatedContent(museums.isNotEmpty(), label = "") { museumsAvailable ->
        if (museumsAvailable) {
            MuseumGrid(
                museums = museums,
                onObjectClick = navigateToDetails,
            )
        } else {
            EmptyScreenContent(Modifier.fillMaxSize())
        }
    }
}

@Composable
private fun MuseumGrid(
    museums: List<Museum>,
    onObjectClick: (Long) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(180.dp),
        modifier = modifier
            .fillMaxSize()
            .padding(WindowInsets.safeDrawing.only(WindowInsetsSides.Horizontal).asPaddingValues()),
        contentPadding = WindowInsets.safeDrawing.only(WindowInsetsSides.Vertical).asPaddingValues(),
    ) {
        items(museums, key = { it.id }) { museum ->
            MuseumFrame(
                museum = museum,
                onClick = { onObjectClick(museum.id) },
            )
        }
    }
}

@Composable
private fun MuseumFrame(
    museum: Museum,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier
            .padding(8.dp)
            .clickable { onClick() }
    ) {
        AsyncImage(
            model = museum.imageSmallUrl,
            contentDescription = museum.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .background(Color.LightGray),
        )

        Spacer(Modifier.height(2.dp))

        Text(museum.title, style = MaterialTheme.typography.subtitle1.copy(fontWeight = FontWeight.Bold))
        Text(museum.artist, style = MaterialTheme.typography.body2)
        Text(museum.date, style = MaterialTheme.typography.caption)
    }
}

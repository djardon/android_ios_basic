package com.ds.dscomposeapp.presentation.detail

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.ds.dscomposeapp.presentation.components.MuseumDetails
import com.ds.dscomposeapp.presentation.empty.EmptyScreenContent
import org.koin.androidx.compose.koinViewModel

@Composable
fun DetailScreen(
    objectId: Long,
    navigateBack: () -> Unit,
    detailViewModel: DetailViewModel = koinViewModel<DetailViewModel>()
) {
    val museum by detailViewModel.museumObject.collectAsState()

    LaunchedEffect(objectId) {
        detailViewModel.setId(objectId)
    }

    AnimatedContent(museum != null, label = "") { museumAvailable ->
        if (museumAvailable) {
            museum?.let {
                MuseumDetails(it, onBackClick = navigateBack)
            }
        } else {
            EmptyScreenContent(Modifier.fillMaxSize())
        }
    }
}


package com.ds.kmmproject.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.ds.kmmproject.SharedRes.images.__platformDetails
import com.ds.kmmproject.domain.models.Museum
import com.ds.kmmproject.shared.R
import dev.icerock.moko.resources.ImageResource

@Composable
fun MuseumDetails(
    museum: Museum,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        topBar = {
            TopAppBar(backgroundColor = MaterialTheme.colors.background) {
                IconButton(onClick = onBackClick) {
                    Icon(painterResource(R.drawable.ic_arrow_back), stringResource(R.string.back))
                }
            }
        },
        modifier = modifier.windowInsetsPadding(WindowInsets.systemBars),
    ) { paddingValues ->
        Column(
            Modifier
                .verticalScroll(rememberScrollState())
                .padding(paddingValues)
        ) {
            AsyncImage(
                model = museum.imageSmallUrl,
                contentDescription = museum.title,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray)
            )

            SelectionContainer {
                Column(Modifier.padding(12.dp)) {
                    Text(museum.title, style = MaterialTheme.typography.h6)
                    Spacer(Modifier.height(6.dp))
                    LabeledInfo(stringResource(R.string.label_artist), museum.artist)
                    LabeledInfo(stringResource(R.string.label_date), museum.date)
                    LabeledInfo(stringResource(R.string.label_dimensions), museum.dimensions)
                    LabeledInfo(stringResource(R.string.label_medium), museum.medium)
                    LabeledInfo(stringResource(R.string.label_department), museum.department)
                    LabeledInfo(stringResource(R.string.label_repository), museum.repository)
                    LabeledInfo(stringResource(R.string.label_credits), museum.creditLine)
                }
            }
        }
    }
}
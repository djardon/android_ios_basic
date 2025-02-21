package com.ds.dscompose.components

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch


@Preview(
    name = "Sample Preview Snackbar Component",
    showBackground = true,
    widthDp = 320,
    heightDp = 640
)
@Composable
fun SnackbarComponent() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SnackbarComponentSample()
    }
}

@Composable
private fun SnackbarComponentSample() {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        val action = snackbarHostState.showSnackbar(
            message = "AdvancedComponents Snackbar UI",
            duration = SnackbarDuration.Short,
            actionLabel = "UNDO",
            withDismissAction = true
        )

        when (action) {
            SnackbarResult.Dismissed -> {
                Log.d("SnackbarComponent","ActionDismissed")
            }
            SnackbarResult.ActionPerformed -> {
                Log.d("SnackbarComponent","ActionPerformed")
            }
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) { innerPadding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                    scope.launch {
                        snackbarHostState.showSnackbar(
                            message = "Preview snackbar from button",
                            actionLabel = "RELOAD",
                            duration = SnackbarDuration.Short
                        )
                    }
                }
            ) {
                Text(text = "Click me!")
            }
        }
    }
}
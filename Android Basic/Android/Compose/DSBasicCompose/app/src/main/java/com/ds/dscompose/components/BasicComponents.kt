package com.ds.dscompose.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.ds.dscompose.R

@Preview(
    name = "Sample Preview Basic Components",
    showBackground = true,
    widthDp = 320,
    heightDp = 640
)
@Composable
fun BasicComponents() {
    val scrollState = rememberScrollState(0)

    LaunchedEffect(Unit) {
        println("Screen BasicComponents loaded")
    }

    Column(
        Modifier.verticalScroll(scrollState)
    ) {
        BasicComponentsColumn()
        BasicComponentsSurface()
        BasicComponentsButton("My Sample button")
        BasicComponentsRow()
        BasicComponentsBox()
        BasicComponentsImage()
        BasicComponentsImageURL()
        BasicComponentsIcon()
    }
}

@Composable
private fun BasicComponentsColumn() {
    var contador by remember { mutableIntStateOf(0) }

    Column(
        Modifier.padding(16.dp)
    ) {
        Text(text = "Contador: $contador")
        Button(onClick = { contador++ }) {
            Text(text = "Incrementar")
        }
    }
}

@Composable
private fun BasicComponentsSurface() {
    Surface(
        color = Color.White,
        modifier = Modifier.padding(16.dp),
        shape = RoundedCornerShape(16.dp),
        shadowElevation = 8.dp
    ) {
        Text(
            text = "¡Hola, Jetpack Compose!",
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
private fun BasicComponentsButton(
    texto: String,
    colorTexto: Color = Color.White,
    colorFondo: Color = Color.Blue
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed = interactionSource.collectIsPressedAsState()
    val isEnabled = remember { mutableStateOf(true) }

    Button(
        modifier = Modifier.padding(16.dp),
        enabled = isEnabled.value,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (!isPressed.value) Color.Magenta else Color.Green,
            disabledContainerColor = Color.Gray,
            contentColor = Color.Yellow,
            disabledContentColor = Color.LightGray
        ),
        interactionSource = interactionSource,
        onClick = { /* Action */ }
    ) {
        Text(text = texto, color = colorTexto)
    }
}

@Composable
private fun BasicComponentsRow() {
    val scrollState = rememberScrollState(0)

    Row(
        Modifier
            .padding(16.dp)
            .border(1.dp, Color.LightGray)
            .horizontalScroll(scrollState)
            .padding(8.dp)
    ) {
        Text(
            text = "Elemento A",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Blue
        )
        Spacer(modifier = Modifier.width(20.dp))
        Text(
            text = "Elemento B",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Cyan
        )
        Spacer(modifier = Modifier.width(20.dp))
        Text(
            text = "Elemento C",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Magenta
        )
    }
}

@Composable
private fun BasicComponentsBox() {
    Box(
        Modifier.padding(16.dp)
    ) {
        Box(
            Modifier
                .background(Color.Red)
                .size(167.dp, 45.dp)
        )
        Button(onClick = {}) {
            Icon(Icons.Filled.Favorite, contentDescription = null)
            Spacer(Modifier.width(8.dp))
            Text(text = "Botón encima")
        }
    }
}

@Composable
private fun BasicComponentsImage() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_foreground),
        contentDescription = "Imagen de prueba"
    )
}

@Composable
private fun BasicComponentsImageURL() {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data("https://developer.android.com/static/images/spot-icons/jetpack-compose.svg?hl=es-419")
            .crossfade(true)
            .build(),
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = Modifier.clip(CircleShape)
    )
}

@Composable
private fun BasicComponentsIcon() {
    Icon(
        imageVector = Icons.Filled.Favorite,
        contentDescription = "Icon favorite",
        tint = Color.Red,
        modifier = Modifier
            .padding(16.dp)
            .size(40.dp)
    )
}
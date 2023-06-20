package com.hainm.enrichskillmockproject.ui.component.welcome

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.hainm.enrichskillmockproject.R
import com.hainm.enrichskillmockproject.ui.component.common.animateAlignmentAsState

@Composable
fun WelcomeThumbnail(ratio: State<Float>) {
    val alignment by animateAlignmentAsState(ratio.value)
    Image(
        painter = painterResource(id = R.drawable.welcome_thumbnail),
        contentDescription = "Welcome thumbnail",
        contentScale = ContentScale.Crop,
        modifier = Modifier.drawWithCache {
            val gradient = Brush.verticalGradient(
                colors = listOf(Color.Transparent, Color.Black),
                startY = 0f,
                endY = size.height * 4 / 5,
                tileMode = TileMode.Clamp,
            )
            onDrawWithContent {
                drawContent()
                drawRect(gradient, blendMode = BlendMode.Multiply)
            }
        },
        alignment = alignment,
    )
}
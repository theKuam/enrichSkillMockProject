package com.hainm.enrichskillmockproject.ui.component.article.button

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.hainm.enrichskillmockproject.R
import com.hainm.enrichskillmockproject.ui.theme.Fuchsia


@Composable
fun ArticleLoveButton() {
    var isLoved by remember { mutableStateOf(false) }
    val color = if (isLoved) Fuchsia else Color.White
    val image = if (isLoved) R.drawable.heart_off_24 else R.drawable.heart_on_24

    Image(
        modifier = Modifier
            .size(24.dp)
            .background(
                color = color,
                shape = CircleShape
            )
            .padding(6.dp)
            .clickable { isLoved = !isLoved },
        painter = painterResource(id = image),
        contentDescription = "back",
        contentScale = ContentScale.Inside,
    )
}
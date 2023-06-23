package com.hainm.enrichskillmockproject.ui.component.article.button

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.hainm.enrichskillmockproject.R


@Composable
fun ArticleBackButton(onBackPressed: () -> Unit) {
    Box(
        modifier = Modifier
            .size(24.dp)
            .background(
                color = Color.White.copy(0.28f),
                shape = CircleShape
            )
            .clickable { onBackPressed() }
    ) {
        Image(
            painter = painterResource(id = R.drawable.indicator_left_24),
            contentDescription = "back",
            contentScale = ContentScale.Inside,
            colorFilter = ColorFilter.tint(Color.Gray)
        )
    }
}
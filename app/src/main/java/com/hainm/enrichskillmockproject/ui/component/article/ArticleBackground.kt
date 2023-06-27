package com.hainm.enrichskillmockproject.ui.component.article

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import coil.compose.AsyncImage
import com.hainm.enrichskillmockproject.data.model.Article
import com.hainm.enrichskillmockproject.ui.theme.HomeCategoryBackground

@Composable
fun ArticleBackground(article: Article) {
    AsyncImage(
        modifier = Modifier
            .fillMaxSize()
            .drawWithCache {
                val gradient = Brush.verticalGradient(
                    colors = listOf(Color.Transparent, HomeCategoryBackground),
                    startY = 0f,
                    endY = size.height * 0.7f,
                    tileMode = TileMode.Clamp,
                )
                onDrawWithContent {
                    drawContent()
                    drawRect(gradient, blendMode = BlendMode.SrcOver)
                }
            }
            .layoutId("background"),
        model = article.image,
        contentDescription = article.title,
        contentScale = ContentScale.Crop,
    )
}
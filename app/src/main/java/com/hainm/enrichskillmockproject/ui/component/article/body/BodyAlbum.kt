package com.hainm.enrichskillmockproject.ui.component.article.body

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.hainm.enrichskillmockproject.data.model.Article
import com.hainm.enrichskillmockproject.ui.theme.Spacing


@Composable
fun BodyAlbum(article: Article) {
    LazyColumn(
        modifier = Modifier
            .padding(
                top = Spacing.large,
                start = Spacing.large,
                end = Spacing.large,
            ),
    ) {
        item {
            AsyncImage(
                modifier = Modifier
                    .clip(RoundedCornerShape(14.dp))
                    .fillMaxWidth(),
                model = article.image,
                contentDescription = article.description,
                contentScale = ContentScale.FillWidth,
            )
        }
    }
}
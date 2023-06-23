package com.hainm.enrichskillmockproject.ui.component.article.body

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.hainm.enrichskillmockproject.common.util.nullOrEmpty
import com.hainm.enrichskillmockproject.data.model.Article
import com.hainm.enrichskillmockproject.ui.theme.AppTextStyle
import com.hainm.enrichskillmockproject.ui.theme.Spacing

@Composable
fun BodyOverview(article: Article) {
    LazyColumn(
        modifier = Modifier
            .padding(
                top = Spacing.large,
                start = Spacing.large,
                end = Spacing.large,
            ),
    ) {
        item {
            Text(
                text = article.content.nullOrEmpty().replace("\n", "\n\n"),
                style = AppTextStyle.ContentText,
                textAlign = TextAlign.Justify,
            )
        }
        item {
            Spacer(modifier = Modifier.height(Spacing.large))
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
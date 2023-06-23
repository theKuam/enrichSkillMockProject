package com.hainm.enrichskillmockproject.ui.component.home.article

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.hainm.enrichskillmockproject.R
import com.hainm.enrichskillmockproject.common.util.nullOrEmpty
import com.hainm.enrichskillmockproject.data.model.Article
import com.hainm.enrichskillmockproject.ui.theme.AppTextStyle
import com.hainm.enrichskillmockproject.ui.theme.ArticleItemBackground
import com.hainm.enrichskillmockproject.ui.theme.Spacing

@Composable
fun ArticleGridItem(
    article: Article,
    onNavigate: (Article) -> Unit,
) {
    Column(
        modifier = Modifier
            .wrapContentSize()
            .background(
                color = ArticleItemBackground,
                shape = RoundedCornerShape(Spacing.medium),
            )
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(0.95f)
                .padding(Spacing.small)
                .clip(shape = RoundedCornerShape(14.dp))
                .clipToBounds(),
            model = article.image,
            contentDescription = article.description,
            contentScale = ContentScale.Crop,
        )
        Text(
            modifier = Modifier.padding(horizontal = Spacing.smallMedium),
            text = article.title.nullOrEmpty(),
            style = AppTextStyle.NunitoCommonText,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
        )
        Row(
            modifier = Modifier
                .padding(Spacing.smallMedium)
                .clickable { onNavigate(article) },
            horizontalArrangement = Arrangement.spacedBy(2.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                modifier = Modifier
                    .size(Spacing.smallMedium),
                painter = painterResource(id = R.drawable.menu_24),
                contentDescription = "hamburger",
            )
            Text(
                text = stringResource(id = R.string.read),
                style = AppTextStyle.NunitoSubtitleText,
            )
        }
    }
}

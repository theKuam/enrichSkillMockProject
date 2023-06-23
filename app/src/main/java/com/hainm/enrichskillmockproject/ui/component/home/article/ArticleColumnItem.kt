package com.hainm.enrichskillmockproject.ui.component.home.article

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
fun ArticleColumnItem(article: Article) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(
                color = ArticleItemBackground,
                shape = RoundedCornerShape(10.dp),
            )
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxHeight()
                .aspectRatio(1.46f)
                .clip(shape = RoundedCornerShape(10.dp))
                .clipToBounds(),
            model = article.image,
            contentDescription = article.description,
            contentScale = ContentScale.Crop,
        )
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(Spacing.smallMedium),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = article.title.nullOrEmpty(),
                style = AppTextStyle.NunitoMediumText,
                maxLines = 4,
                overflow = TextOverflow.Ellipsis,
            )
            Row(
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
}
package com.hainm.enrichskillmockproject.ui.component.article

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hainm.enrichskillmockproject.data.model.Article
import com.hainm.enrichskillmockproject.ui.component.article.header.HeaderPublishedDate
import com.hainm.enrichskillmockproject.ui.component.article.header.HeaderSource
import com.hainm.enrichskillmockproject.ui.component.article.header.HeaderTitle
import com.hainm.enrichskillmockproject.ui.theme.Spacing
import com.hainm.enrichskillmockproject.ui.theme.WhiteGreyText

@Composable
fun ArticleContentHeader(article: Article) {
    Column(modifier = Modifier.padding(Spacing.large)) {
        HeaderTitle(article)
        Spacer(modifier = Modifier.height(Spacing.extraSmall))
        HeaderSource(article)
        Divider(
            modifier = Modifier.padding(vertical = Spacing.smallMedium),
            thickness = 0.4.dp,
            color = WhiteGreyText,
        )
        HeaderPublishedDate(article)
    }
}
package com.hainm.enrichskillmockproject.ui.component.article.header

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.hainm.enrichskillmockproject.common.util.nullOrEmpty
import com.hainm.enrichskillmockproject.data.model.Article
import com.hainm.enrichskillmockproject.ui.theme.AppTextStyle

@Composable
fun HeaderTitle(article: Article) {
    Text(
        text = article.title.nullOrEmpty(),
        style = AppTextStyle.ArticleTitle,
    )
}
package com.hainm.enrichskillmockproject.ui.component.article

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.hainm.enrichskillmockproject.data.model.Article

@ExperimentalFoundationApi
@Composable
fun ArticleContent(
    article: Article,
    bodyHeaderBg: Color,
    bodyPagerBg: Color,
    textColor: Color,
) {
    ArticleContentHeader(
        article,
        bodyHeaderBg,
        textColor,
    )
    ArticleContentBody(
        article,
        bodyHeaderBg,
        bodyPagerBg,
        textColor,
    )
}
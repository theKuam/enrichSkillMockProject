package com.hainm.enrichskillmockproject.ui.component.article

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.hainm.enrichskillmockproject.ui.model.ArticleModel

@ExperimentalFoundationApi
@Composable
fun ArticleContent(
    article: ArticleModel,
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
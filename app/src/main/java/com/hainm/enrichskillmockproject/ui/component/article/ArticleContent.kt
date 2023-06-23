package com.hainm.enrichskillmockproject.ui.component.article

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.hainm.enrichskillmockproject.data.model.Article

@ExperimentalFoundationApi
@Composable
fun BoxScope.ArticleContent(article: Article) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.5f)
            .align(Alignment.BottomStart),
    ) {
        ArticleContentHeader(article)
        ArticleContentBody(article)
    }
}
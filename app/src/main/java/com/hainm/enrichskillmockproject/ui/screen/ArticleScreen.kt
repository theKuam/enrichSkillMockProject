package com.hainm.enrichskillmockproject.ui.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.hainm.enrichskillmockproject.core.BaseScreen
import com.hainm.enrichskillmockproject.data.model.Article
import com.hainm.enrichskillmockproject.ui.component.ArticleButtons
import com.hainm.enrichskillmockproject.ui.component.article.ArticleBackground
import com.hainm.enrichskillmockproject.ui.component.article.ArticleContent

@ExperimentalFoundationApi
@Composable
fun ArticleScreen(
    article: Article,
    onBackPressed: () -> Unit,
) {
    BaseScreen {
        Box(modifier = Modifier.fillMaxSize()) {
            ArticleBackground(article)
            ArticleContent(article)
            ArticleButtons(onBackPressed)
        }
    }
}

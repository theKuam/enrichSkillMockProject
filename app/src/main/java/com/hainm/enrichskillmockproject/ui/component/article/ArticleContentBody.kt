package com.hainm.enrichskillmockproject.ui.component.article

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import com.hainm.enrichskillmockproject.data.model.Article
import com.hainm.enrichskillmockproject.ui.component.article.body.BodyPager
import com.hainm.enrichskillmockproject.ui.component.article.body.BodyTabRow

@ExperimentalFoundationApi
@Composable
fun ArticleContentBody(article: Article) {
    val pagerState = rememberPagerState()
    var currentIndex by remember { mutableStateOf(pagerState.currentPage) }
    Column(
        horizontalAlignment = Alignment.Start,
    ) {
        BodyTabRow(currentIndex) {
            currentIndex = it
        }
        BodyPager(
            pagerState,
            currentIndex,
            article,
        )
    }
}
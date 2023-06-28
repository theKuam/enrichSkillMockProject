package com.hainm.enrichskillmockproject.ui.component.article

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import com.hainm.enrichskillmockproject.common.util.CONTENT_PAGE_COUNT
import com.hainm.enrichskillmockproject.ui.component.article.body.BodyDraggableBar
import com.hainm.enrichskillmockproject.ui.component.article.body.BodyPager
import com.hainm.enrichskillmockproject.ui.component.article.body.BodyTabRow
import com.hainm.enrichskillmockproject.ui.model.ArticleModel

@ExperimentalFoundationApi
@Composable
fun ArticleContentBody(
    article: ArticleModel,
    bodyHeaderBg: Color,
    bodyPagerBg: Color,
    textColor: Color,
) {
    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ) {
        CONTENT_PAGE_COUNT
    }
    var currentIndex by remember { mutableIntStateOf(pagerState.currentPage) }
    BodyTabRow(
        bodyHeaderBg,
        currentIndex,
    ) {
        currentIndex = it
    }
    BodyPager(
        pagerState,
        currentIndex,
        article,
        bodyPagerBg,
        textColor,
    )
    BodyDraggableBar(textColor)
}
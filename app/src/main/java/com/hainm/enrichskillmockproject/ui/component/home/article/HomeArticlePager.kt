package com.hainm.enrichskillmockproject.ui.component.home.article

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import com.hainm.enrichskillmockproject.common.Outcome
import com.hainm.enrichskillmockproject.domain.model.Article
import com.hainm.enrichskillmockproject.ui.model.ArticleModel
import com.hainm.enrichskillmockproject.ui.theme.Spacing

@ExperimentalFoundationApi
@Composable
fun HomeArticlePager(
    pagerState: PagerState,
    onPauseButtonClicked: () -> Unit,
    articles: State<Outcome<List<Article>>>,
    onCategoryChange: (String) -> Unit,
    onSubCategoryChange: (String) -> Unit,
    onNavigate: (ArticleModel) -> Unit,
) {

    HomeArticleTabs(
        pagerState,
        onPauseButtonClicked,
        onCategoryChange,
        onSubCategoryChange,
    )

    Spacer(modifier = Modifier.height(Spacing.medium))

    HomeArticleList(
        articles,
        onNavigate,
    )
}
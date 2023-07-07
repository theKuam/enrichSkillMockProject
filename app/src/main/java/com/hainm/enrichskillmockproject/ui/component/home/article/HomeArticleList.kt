package com.hainm.enrichskillmockproject.ui.component.home.article

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.hainm.enrichskillmockproject.common.Outcome
import com.hainm.enrichskillmockproject.common.failed
import com.hainm.enrichskillmockproject.common.loading
import com.hainm.enrichskillmockproject.common.succeeded
import com.hainm.enrichskillmockproject.common.util.nullOrZero
import com.hainm.enrichskillmockproject.domain.model.Article
import com.hainm.enrichskillmockproject.ui.adapter.ArticleAdapter.toArticleModelList
import com.hainm.enrichskillmockproject.ui.component.common.LoadingView
import com.hainm.enrichskillmockproject.ui.model.ArticleModel
import com.hainm.enrichskillmockproject.ui.theme.Spacing

@ExperimentalFoundationApi
@Composable
fun HomeArticleList(
    articles: State<Outcome<List<Article>>>,
    onNavigate: (ArticleModel) -> Unit,
) {
    val firstHalfList = arrayListOf<ArticleModel>()
    val secondHalfList = arrayListOf<ArticleModel>()
    var articleListSize by remember { mutableIntStateOf(0) }
    var onClickShowAllGrid by remember { mutableStateOf(false) }
    var onClickShowAllColumn by remember { mutableStateOf(false) }
    with(articles.value) {
        when {
            succeeded -> {
                val result = data
                articleListSize = result?.size.nullOrZero()
                if (articleListSize != 0) {
                    result.toArticleModelList().let {
                        val halfSize = articleListSize / 2
                        firstHalfList.addAll(
                            if (articleListSize == 1) it else it.subList(
                                0,
                                halfSize
                            )
                        )
                        secondHalfList.addAll(
                            if (articleListSize == 1) it else it.subList(
                                halfSize,
                                articleListSize
                            )
                        )
                    }
                }
            }

            loading -> {
                articleListSize = -1
            }

            failed -> {
                articleListSize = 0
            }

            else -> {}
        }

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(Spacing.medium),
            horizontalArrangement = Arrangement.spacedBy(Spacing.medium),
            verticalArrangement = Arrangement.spacedBy(Spacing.medium),
        ) {
            item(span = { GridItemSpan(2) }) {
                ArticleListTitle { onClickShowAllGrid = !onClickShowAllGrid }
            }
            when (articleListSize) {
                -1 -> item(span = { GridItemSpan(2) }) {
                    LoadingView()
                }

                0 -> item(span = { GridItemSpan(2) }) {
                    NoArticleAvailable()
                }

                else -> items(if (onClickShowAllGrid) firstHalfList.size else 2) { index ->
                    ArticleGridItem(
                        firstHalfList[index],
                        onNavigate,
                    )
                }
            }
            item(span = { GridItemSpan(2) }) {
                ArticleListTitle { onClickShowAllColumn = !onClickShowAllColumn }
            }
            when (articleListSize) {
                -1 -> item(span = { GridItemSpan(2) }) {
                    LoadingView()
                }

                0 -> item(span = { GridItemSpan(2) }) {
                    NoArticleAvailable()
                }

                else -> {
                    val size = if (onClickShowAllColumn) secondHalfList.size else 1
                    secondHalfList.subList(0, size).forEachIndexed { index, _ ->
                        item(span = { GridItemSpan(2) }) {
                            ArticleColumnItem(
                                secondHalfList[index],
                                onNavigate,
                            )
                        }
                    }
                }
            }
        }
    }
}
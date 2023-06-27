package com.hainm.enrichskillmockproject.ui.component.article

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import com.hainm.enrichskillmockproject.ui.component.article.button.ArticleBackButton
import com.hainm.enrichskillmockproject.ui.component.article.button.ArticleLoveButton
import com.hainm.enrichskillmockproject.ui.theme.Spacing


@Composable
fun ArticleButtons(onBackPressed: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(Spacing.large)
            .statusBarsPadding()
            .layoutId("buttons"),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        ArticleBackButton(onBackPressed)
        ArticleLoveButton()
    }
}
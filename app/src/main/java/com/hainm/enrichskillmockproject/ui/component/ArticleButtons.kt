package com.hainm.enrichskillmockproject.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.hainm.enrichskillmockproject.ui.component.article.button.ArticleBackButton
import com.hainm.enrichskillmockproject.ui.component.article.button.ArticleLoveButton
import com.hainm.enrichskillmockproject.ui.theme.Spacing


@Composable
fun BoxScope.ArticleButtons(onBackPressed: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(Spacing.large)
            .statusBarsPadding()
            .align(Alignment.TopCenter),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        ArticleBackButton(onBackPressed)
        ArticleLoveButton()
    }
}
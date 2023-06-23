package com.hainm.enrichskillmockproject.ui.component.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.hainm.enrichskillmockproject.R
import com.hainm.enrichskillmockproject.ui.theme.AppTextStyle

@Composable
fun ArticleListTitle(onShowAllClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = stringResource(id = R.string.recommended_article),
            style = AppTextStyle.RecommendedArticle,
        )
        Text(
            modifier = Modifier.clickable { onShowAllClick() },
            text = stringResource(id = R.string.show_all),
            style = AppTextStyle.ShowAll,
        )
    }
}
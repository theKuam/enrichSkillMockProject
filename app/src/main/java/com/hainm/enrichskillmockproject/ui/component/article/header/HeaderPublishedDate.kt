package com.hainm.enrichskillmockproject.ui.component.article.header

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.hainm.enrichskillmockproject.R
import com.hainm.enrichskillmockproject.ui.model.ArticleModel
import com.hainm.enrichskillmockproject.ui.theme.AppTextStyle

@Composable
fun HeaderPublishedDate(
    article: ArticleModel,
    textColor: Color,
) {
    Text(
        text = stringResource(id = R.string.published) + " ${article.publishAt}",
        style = AppTextStyle.NunitoLightMediumText,
        color = textColor,
    )
}
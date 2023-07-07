package com.hainm.enrichskillmockproject.ui.component.article.header

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.hainm.enrichskillmockproject.R
import com.hainm.enrichskillmockproject.ui.model.ArticleModel
import com.hainm.enrichskillmockproject.ui.theme.AppTextStyle
import com.hainm.enrichskillmockproject.ui.theme.ArticleSourceName
import com.hainm.enrichskillmockproject.ui.theme.Spacing

@Composable
fun HeaderSource(
    article: ArticleModel,
    textColor: Color,
) {
    Row {
        Text(
            text = stringResource(id = R.string.by),
            style = AppTextStyle.NunitoLightMediumText,
            color = textColor,
        )
        Spacer(modifier = Modifier.width(Spacing.extraSmall))
        Text(
            text = article.sourceName,
            style = AppTextStyle.NunitoMediumText,
            color = ArticleSourceName,
        )
    }
}
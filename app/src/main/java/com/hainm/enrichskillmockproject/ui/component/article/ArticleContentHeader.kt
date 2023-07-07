package com.hainm.enrichskillmockproject.ui.component.article

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import com.hainm.enrichskillmockproject.ui.component.article.header.HeaderPublishedDate
import com.hainm.enrichskillmockproject.ui.component.article.header.HeaderSource
import com.hainm.enrichskillmockproject.ui.component.article.header.HeaderTitle
import com.hainm.enrichskillmockproject.ui.model.ArticleModel
import com.hainm.enrichskillmockproject.ui.theme.Spacing
import com.hainm.enrichskillmockproject.ui.theme.WhiteGreyText

@Composable
fun ArticleContentHeader(
    article: ArticleModel,
    bodyHeaderBg: Color,
    textColor: Color,
) {
    Column(
        modifier = Modifier
            .background(
                color = bodyHeaderBg,
                shape = RoundedCornerShape(
                    topStart = Spacing.large,
                    topEnd = Spacing.large,
                )
            )
            .padding(Spacing.large)
            .layoutId("header"),
    ) {
        HeaderTitle(
            article,
            textColor,
        )
        Spacer(modifier = Modifier.height(Spacing.extraSmall))
        HeaderSource(
            article,
            textColor,
        )
        Divider(
            modifier = Modifier.padding(vertical = Spacing.smallMedium),
            thickness = 0.4.dp,
            color = WhiteGreyText,
        )
        HeaderPublishedDate(
            article,
            textColor,
        )
    }
}
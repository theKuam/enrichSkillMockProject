package com.hainm.enrichskillmockproject.ui.component.article.header

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import com.hainm.enrichskillmockproject.ui.model.ArticleModel
import com.hainm.enrichskillmockproject.ui.theme.AppTextStyle

@Composable
fun HeaderTitle(
    article: ArticleModel,
    textColor: Color,
) {
    var textSize by remember { mutableStateOf(AppTextStyle.ArticleTitle.fontSize) }

    Text(
        text = article.title,
        style = AppTextStyle.ArticleTitle,
        color = textColor,
        fontSize = textSize,
        maxLines = 2,
        overflow = TextOverflow.Ellipsis,
        onTextLayout = { textLayoutResult ->
            val maxCurrentLineIndex = textLayoutResult.lineCount - 1

            if (textLayoutResult.isLineEllipsized(maxCurrentLineIndex)) {
                textSize = textSize.times(0.9f)
            }
        }
    )
}
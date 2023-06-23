package com.hainm.enrichskillmockproject.ui.component.article.header

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.hainm.enrichskillmockproject.R
import com.hainm.enrichskillmockproject.common.util.DateTimeFormat
import com.hainm.enrichskillmockproject.common.util.nullOrEmpty
import com.hainm.enrichskillmockproject.data.model.Article
import com.hainm.enrichskillmockproject.ui.theme.AppTextStyle
import timber.log.Timber
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale

@Composable
fun HeaderPublishedDate(article: Article) {
    val date = try {
        val input = SimpleDateFormat(DateTimeFormat.RESPONSE_FORMAT, Locale.getDefault())
            .parse(article.publishAt.nullOrEmpty()) ?: Date()
        SimpleDateFormat(DateTimeFormat.UI_FORMAT, Locale.getDefault()).format(input)

    } catch (e: Exception) {
        Timber.e("Can not parse date")
        LocalDate.now().format(DateTimeFormatter.ofPattern(DateTimeFormat.UI_FORMAT)).toString()

    }
    Text(
        text = stringResource(id = R.string.published) + " $date",
        style = AppTextStyle.NunitoLightMediumText,
    )
}
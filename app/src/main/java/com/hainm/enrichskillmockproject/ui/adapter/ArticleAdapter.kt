package com.hainm.enrichskillmockproject.ui.adapter

import com.hainm.enrichskillmockproject.common.util.DateTimeFormat
import com.hainm.enrichskillmockproject.common.util.nullOrEmpty
import com.hainm.enrichskillmockproject.domain.model.Article
import com.hainm.enrichskillmockproject.ui.model.ArticleModel
import timber.log.Timber
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale

object ArticleAdapter {
    private fun String?.toFormattedDateTimeString() = try {
        val input = SimpleDateFormat(DateTimeFormat.RESPONSE_FORMAT, Locale.getDefault())
            .parse(nullOrEmpty()) ?: Date()
        SimpleDateFormat(DateTimeFormat.UI_FORMAT, Locale.getDefault()).format(input)

    } catch (e: Exception) {
        Timber.e("Can not parse date")
        LocalDate.now().format(DateTimeFormatter.ofPattern(DateTimeFormat.UI_FORMAT)).toString()
    }

    private fun String?.toSpaciousParagraph(): String = nullOrEmpty().replace("\n", "\n\n")

    private fun Article.toArticleModel() = ArticleModel(
        title = title.nullOrEmpty(),
        description = description.nullOrEmpty(),
        content = content.toSpaciousParagraph(),
        url = url.nullOrEmpty(),
        image = image.nullOrEmpty(),
        publishAt = publishAt.toFormattedDateTimeString(),
        sourceName = sourceName.nullOrEmpty(),
        sourceUrl = sourceUrl.nullOrEmpty(),
    )

    fun List<Article>?.toArticleModelList() = this?.map { article -> article.toArticleModel() } ?: listOf()
}
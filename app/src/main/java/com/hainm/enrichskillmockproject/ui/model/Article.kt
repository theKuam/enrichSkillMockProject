package com.hainm.enrichskillmockproject.ui.model

import com.hainm.enrichskillmockproject.common.util.EMPTY_STRING

data class ArticleModel(
    val title: String = EMPTY_STRING,
    val description: String = EMPTY_STRING,
    val content: String = EMPTY_STRING,
    val url: String = EMPTY_STRING,
    val image: String = EMPTY_STRING,
    val publishAt: String = EMPTY_STRING,
    val sourceName: String = EMPTY_STRING,
    val sourceUrl: String = EMPTY_STRING,
)
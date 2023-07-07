package com.hainm.enrichskillmockproject.data.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ArticlesEntity(
    @Json(name = "totalArticles") val total: Int?,
    @Json(name = "articles") val articles: List<ArticleEntity>?,
)

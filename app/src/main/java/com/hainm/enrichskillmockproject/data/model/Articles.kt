package com.hainm.enrichskillmockproject.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Articles(
    @Json(name = "totalArticles") val total: Int?,
    @Json(name = "articles") val articles: List<Article>?,
)

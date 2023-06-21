package com.hainm.enrichskillmockproject.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Article(
    @Json(name = "title") val title: String?,
    @Json(name = "description") val description: String?,
    @Json(name = "content") val content: String?,
    @Json(name = "url") val url: String?,
    @Json(name = "image") val image: String?,
    @Json(name = "publishedAt") val publishAt: String?,
    @Json(name = "source") val source: Source?,
)

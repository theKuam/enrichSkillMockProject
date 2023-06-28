package com.hainm.enrichskillmockproject.data.datasource.remote.service

import com.hainm.enrichskillmockproject.common.util.Category
import com.hainm.enrichskillmockproject.common.util.SubCategory
import com.hainm.enrichskillmockproject.data.entity.ArticlesEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface ArticleService {
    @GET("top-headlines")
    suspend fun getRecommendedArticles(
        @Query("category") category: String = Category.GENERAL,
        @Query("q") subCategory: String = SubCategory.ANIMAL,
        @Query("max") max: Int = 10,
        @Query("expand") expand: Boolean = true,
    ): ArticlesEntity
}
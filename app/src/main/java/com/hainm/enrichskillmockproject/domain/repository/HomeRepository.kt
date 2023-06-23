package com.hainm.enrichskillmockproject.domain.repository

import com.hainm.enrichskillmockproject.common.Outcome
import com.hainm.enrichskillmockproject.data.model.Articles
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    fun getRecommendedArticles(category: String, subCategory: String): Flow<Outcome<Articles>>
}
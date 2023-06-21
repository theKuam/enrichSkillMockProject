package com.hainm.enrichskillmockproject.data.repository

import com.hainm.enrichskillmockproject.common.Outcome
import com.hainm.enrichskillmockproject.data.model.Articles
import com.hainm.enrichskillmockproject.di.coroutine.IoDispatcher
import com.hainm.enrichskillmockproject.domain.repository.HomeRepository
import com.hainm.enrichskillmockproject.service.ArticleService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val articleService: ArticleService,
    @IoDispatcher private val coroutineDispatcher: CoroutineDispatcher,
) : HomeRepository {
    override fun getRecommendedArticles(
        category: String,
        subCategory: String,
    ): Flow<Outcome<Articles>> = flow {
        val response = articleService.getRecommendedArticles(category, subCategory)
        emit(Outcome.Success(response))
    }.flowOn(coroutineDispatcher)
}
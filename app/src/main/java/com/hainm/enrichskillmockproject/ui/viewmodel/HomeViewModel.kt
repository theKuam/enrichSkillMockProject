package com.hainm.enrichskillmockproject.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hainm.enrichskillmockproject.common.Outcome
import com.hainm.enrichskillmockproject.common.util.CAROUSEL_AUTOPLAY_PAUSE_DURATION
import com.hainm.enrichskillmockproject.data.model.Articles
import com.hainm.enrichskillmockproject.domain.usecase.GetRecommendedArticlesUseCase
import com.hainm.enrichskillmockproject.domain.usecase.Parameters
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getRecommendedArticlesUseCase: GetRecommendedArticlesUseCase,
) : ViewModel() {
    private val _articlesStateFlow = MutableStateFlow<Outcome<Articles>>(Outcome.NotLoading)
    val articlesStateFlow: StateFlow<Outcome<Articles>>
        get() = _articlesStateFlow.asStateFlow()

    private val _isCarouselAutoPlayed = MutableStateFlow(true)
    val isCarouselAutoPlayed: StateFlow<Boolean>
        get() = _isCarouselAutoPlayed.asStateFlow()

    private var timerJob: Job? = null

    fun getRecommendedArticles(
        category: String,
        subCategory: String,
    ) {
        viewModelScope.launch {
            getRecommendedArticlesUseCase.invoke(
                Parameters(
                    category,
                    subCategory,
                )
            ).onStart {
                _articlesStateFlow.value = Outcome.Loading
            }
                .catch {
                    _articlesStateFlow.value = Outcome.Error(it)
                }.collectLatest {
                    _articlesStateFlow.value = it
                }
        }
    }

    fun stopAutoPlayed() {
        timerJob?.cancel()
        timerJob = viewModelScope.launch {
            _isCarouselAutoPlayed.value = false
            delay(CAROUSEL_AUTOPLAY_PAUSE_DURATION)
            _isCarouselAutoPlayed.value = true
        }
    }

    fun startAutoPlayed() {
        timerJob?.cancel()
        _isCarouselAutoPlayed.value = true
    }
}
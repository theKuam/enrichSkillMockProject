package com.hainm.enrichskillmockproject.common.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hainm.enrichskillmockproject.common.succeeded
import com.hainm.enrichskillmockproject.domain.usecase.GetFirstLaunchUseCase
import com.hainm.enrichskillmockproject.domain.usecase.SetFirstLaunchUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SharedPreferenceViewModel @Inject constructor(
    private val setFirstLaunchUseCase: SetFirstLaunchUseCase,
    private val getFirstLaunchUseCase: GetFirstLaunchUseCase,
) : ViewModel() {
    private val _isFirstLaunch = MutableStateFlow(true)
    val isFirstLaunch: StateFlow<Boolean>
        get() = _isFirstLaunch.asStateFlow()

    fun setFirstLaunch() {
        viewModelScope.launch {
            setFirstLaunchUseCase.invoke(Unit)
        }
    }

    suspend fun getFirstLaunch() {
        viewModelScope.launch {
            getFirstLaunchUseCase.invoke(Unit).collectLatest { result ->
                if (result.succeeded) {
                    _isFirstLaunch.value = result.data ?: true
                } else {
                    _isFirstLaunch.value = true
                }
            }
        }
    }
}


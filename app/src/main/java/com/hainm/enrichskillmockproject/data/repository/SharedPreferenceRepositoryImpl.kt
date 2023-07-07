package com.hainm.enrichskillmockproject.data.repository

import android.content.SharedPreferences
import com.hainm.enrichskillmockproject.domain.repository.SharedPreferenceRepository
import javax.inject.Inject

class SharedPreferenceRepositoryImpl @Inject constructor(private val sharedPreferences: SharedPreferences) :
    SharedPreferenceRepository {
    companion object {
        private const val IS_FIRST_LAUNCH = "IS_FIRST_LAUNCH"
    }

    override fun setFirstLaunch() {
        sharedPreferences.edit().putBoolean(IS_FIRST_LAUNCH, false).apply()
    }

    override fun getFirstLaunch(): Boolean = sharedPreferences.getBoolean(IS_FIRST_LAUNCH, true)
}
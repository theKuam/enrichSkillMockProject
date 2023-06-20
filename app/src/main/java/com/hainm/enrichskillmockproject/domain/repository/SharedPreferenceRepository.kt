package com.hainm.enrichskillmockproject.domain.repository

interface SharedPreferenceRepository {
    fun setFirstLaunch()

    fun getFirstLaunch(): Boolean
}
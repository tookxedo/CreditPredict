package com.ryan.creditpredict.ui

import android.content.Context
import com.ryan.creditpredict.data.PredictionRepository
import com.ryan.creditpredict.data.retrofit.ApiConfig

object Injection {
    fun provideRepository(context: Context): PredictionRepository {
        val apiService = ApiConfig.apiService()
        return PredictionRepository.getInstance(apiService)
    }
}
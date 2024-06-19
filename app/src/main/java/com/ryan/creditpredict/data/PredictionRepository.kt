package com.ryan.creditpredict.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.google.gson.JsonObject
import com.ryan.creditpredict.data.retrofit.response.PostResponse
import com.ryan.creditpredict.data.retrofit.ApiService
import kotlinx.coroutines.Dispatchers
import retrofit2.http.Field
import kotlin.time.Duration

class PredictionRepository(private val apiService: ApiService) {

    fun postPrediction(dataForms: JsonObject
    ): LiveData<Result<PostResponse>> =
        liveData(Dispatchers.IO) {
            emit(Result.Loading)
            try {
                val response = apiService.postPrediction(dataForms)
                emit(Result.Success(response))
            } catch (e: Exception) {
                emit(Result.Error(e.message.toString()))
            }
        }
    companion object {
        @Volatile
        private var instance: PredictionRepository? = null
        fun getInstance(
            apiService: ApiService,
        ): PredictionRepository =
            instance ?: synchronized(this) {
                instance ?: PredictionRepository(apiService)
            }.also { instance = it }
    }
}
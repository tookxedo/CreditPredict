package com.ryan.creditpredict.data.retrofit

import com.google.gson.JsonObject
import com.ryan.creditpredict.data.retrofit.response.PostResponse
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.POST
import retrofit2.http.FormUrlEncoded

interface ApiService {

    @POST("prediction")
    suspend fun postPrediction(
        @Body dataForms: JsonObject
    ): PostResponse
}
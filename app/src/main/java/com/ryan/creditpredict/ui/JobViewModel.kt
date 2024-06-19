package com.ryan.creditpredict.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.JsonObject
import com.ryan.creditpredict.data.retrofit.response.PostResponse
import com.ryan.creditpredict.data.PredictionRepository
import com.ryan.creditpredict.data.Result

class JobViewModel(private val repository: PredictionRepository) : ViewModel() {

    private val _jobViewModel = MediatorLiveData<Result<PostResponse>>()
    val jobViewModel: LiveData<Result<PostResponse>> = _jobViewModel

    fun postPrediction(dataForms: JsonObject
    ) {
        val liveData = repository.postPrediction(dataForms)
        _jobViewModel.addSource(liveData) { result ->
            _jobViewModel.value = result
        }
    }
}
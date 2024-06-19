package com.ryan.creditpredict.data.retrofit.response

import com.google.gson.annotations.SerializedName

data class PostResponse(

	@field:SerializedName("prediction")
	val prediction: String? = null
)

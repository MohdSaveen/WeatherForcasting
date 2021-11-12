package com.example.realweatherforecast

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ConditionDTO(

	@field:SerializedName("text")
	val text: String? = null,

	@field:SerializedName("icon")
	val icon: String? = null,

	@field:SerializedName("code")
	val code: Int? = null
)
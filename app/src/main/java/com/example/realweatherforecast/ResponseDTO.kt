package com.example.realweatherforecast

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ResponseDTO(

	@field:SerializedName("location")
	val location: LocationDTO? = null,

	@field:SerializedName("current")
	val current: CurrentDTO? = null,

	@field:SerializedName("forecast")
	val forecast: ForecastDTO? = null
)
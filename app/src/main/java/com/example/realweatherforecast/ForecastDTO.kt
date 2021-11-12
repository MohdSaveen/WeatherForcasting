package com.example.realweatherforecast

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ForecastDTO(

	@field:SerializedName("forecastday")
	val forecastday: List<ForecastdayDTO?>? = null
)
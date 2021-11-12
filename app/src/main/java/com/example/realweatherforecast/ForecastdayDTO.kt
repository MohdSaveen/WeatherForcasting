package com.example.realweatherforecast

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ForecastdayDTO(

	@field:SerializedName("date")
	val date: String? = null,

	@field:SerializedName("date_epoch")
	val dateEpoch: Int? = null,

	@field:SerializedName("day")
	val day: DayDTO? = null,

	@field:SerializedName("astro")
	val astro: AstroDTO? = null,

	@field:SerializedName("hour")
	val hour: List<HourDTO?>? = null
)
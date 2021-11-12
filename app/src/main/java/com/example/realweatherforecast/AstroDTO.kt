package com.example.realweatherforecast

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class AstroDTO(

	@field:SerializedName("sunrise")
	val sunrise: String? = null,

	@field:SerializedName("sunset")
	val sunset: String? = null,

	@field:SerializedName("moonrise")
	val moonrise: String? = null,

	@field:SerializedName("moonset")
	val moonset: String? = null,

	@field:SerializedName("moon_phase")
	val moonPhase: String? = null,

	@field:SerializedName("moon_illumination")
	val moonIllumination: String? = null
)
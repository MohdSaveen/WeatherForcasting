package com.example.realweatherforecast

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class LocationDTO(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("region")
	val region: String? = null,

	@field:SerializedName("country")
	val country: String? = null,

	@field:SerializedName("lat")
	val lat: Any? = null,

	@field:SerializedName("lon")
	val lon: Any? = null,

	@field:SerializedName("tz_id")
	val tzId: String? = null,

	@field:SerializedName("localtime_epoch")
	val localtimeEpoch: Int? = null,

	@field:SerializedName("localtime")
	val localtime: String? = null
)
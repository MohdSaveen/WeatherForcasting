package com.example.realweatherforecast

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class DayDTO(

	@field:SerializedName("maxtemp_c")
	val maxtempC: Any? = null,

	@field:SerializedName("maxtemp_f")
	val maxtempF: Any? = null,

	@field:SerializedName("mintemp_c")
	val mintempC: Any? = null,

	@field:SerializedName("mintemp_f")
	val mintempF: Any? = null,

	@field:SerializedName("avgtemp_c")
	val avgtempC: Any? = null,

	@field:SerializedName("avgtemp_f")
	val avgtempF: Any? = null,

	@field:SerializedName("maxwind_mph")
	val maxwindMph: Any? = null,

	@field:SerializedName("maxwind_kph")
	val maxwindKph: Any? = null,

	@field:SerializedName("totalprecip_mm")
	val totalprecipMm: Any? = null,

	@field:SerializedName("totalprecip_in")
	val totalprecipIn: Any? = null,

	@field:SerializedName("avgvis_km")
	val avgvisKm: Any? = null,

	@field:SerializedName("avgvis_miles")
	val avgvisMiles: Any? = null,

	@field:SerializedName("avghumidity")
	val avghumidity: Any? = null,

	@field:SerializedName("daily_will_it_rain")
	val dailyWillItRain: Int? = null,

	@field:SerializedName("daily_chance_of_rain")
	val dailyChanceOfRain: Int? = null,

	@field:SerializedName("daily_will_it_snow")
	val dailyWillItSnow: Int? = null,

	@field:SerializedName("daily_chance_of_snow")
	val dailyChanceOfSnow: Int? = null,

	@field:SerializedName("condition")
	val condition: ConditionDTO? = null,

	@field:SerializedName("uv")
	val uv: Any? = null
)
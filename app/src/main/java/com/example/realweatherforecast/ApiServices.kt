package com.example.realweatherforecast

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {

    @GET("/v1/forecast.json")
    fun getUserDetails(@Query("key")key:String,
                       @Query("q")q:String,
                       @Query("days")days:Int): Call<ResponseDTO>


}
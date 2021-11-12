package com.example.realweatherforecast

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_blank.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BlankFragment : Fragment() {

    private val key="5a812faf9e1e4a66b17223056210911"
    private val days=1
    private val q="Delhi"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        callAPI()
    }

    private fun callAPI(){

        val apiServices=Network.getRetrofitInstance().create(ApiServices::class.java)
        apiServices.getUserDetails(key, q, days).enqueue(
            object : Callback<ResponseDTO>{
                override fun onResponse(call: Call<ResponseDTO>, response: Response<ResponseDTO>) {
                    response.body()?.apply {
                        tempView.text=current?.tempC.toString()
                        humidityShowing.text=current?.humidity.toString()
                        weatherView.text=current?.condition?.text
                        uvShowing.text=current?.uv.toString()
                        windSpeedShowing.text=current?.windKph.toString()
                        windFromShowing.text=current?.windDir
                        pressureShowing.text=current?.pressureIn.toString()
                        sunriseshowing.text=forecast?.forecastday?.get(0)?.astro?.sunrise
                        sunsetShowing.text=forecast?.forecastday?.get(0)?.astro?.sunset
                       Glide.with(weatherImageView).load("http:"+current?.condition?.icon).into(weatherImageView)
                    }
                }

                override fun onFailure(call: Call<ResponseDTO>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            }
        )

    }
}
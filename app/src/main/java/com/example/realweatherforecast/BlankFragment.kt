package com.example.realweatherforecast

import android.app.Activity
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import kotlinx.android.synthetic.main.fragment_blank.*
import kotlinx.android.synthetic.main.fragment_blank.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BlankFragment : Fragment() {

    lateinit var fusedLocationProviderClient: FusedLocationProviderClient

    private var hoursDTOList:List<HourDTO> = listOf()
    private var forecastdayDTOList:List<ForecastdayDTO> = listOf()
    private val key = "5a812faf9e1e4a66b17223056210911"
    private val days = 7
    private var name:String="a"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            name= requireArguments().get("name") as String
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_blank, container, false)

        view.searchItem.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_blankFragment_to_searchFragment)
        }

        view.listImageView.setOnClickListener {
            val region=locationTextView.text.toString()
            val bundle=Bundle()
            bundle.putString("region",region)
            Navigation.findNavController(view).navigate(R.id.action_blankFragment_to_hoursTabLayout,bundle)
        }
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(activity)

        fetchLocation()
    }

    private fun fetchLocation() {
        val task =fusedLocationProviderClient.lastLocation


        if (context?.let { ActivityCompat.checkSelfPermission(it,android.Manifest.permission.ACCESS_FINE_LOCATION) }
            != PackageManager.PERMISSION_GRANTED && context?.let {
                ActivityCompat
                    .checkSelfPermission(it,android.Manifest.permission.ACCESS_COARSE_LOCATION)
            } != PackageManager.PERMISSION_GRANTED
        ){
            ActivityCompat.requestPermissions(context as Activity, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),101)
            return
        }
        task.addOnSuccessListener {
            if (it!= null){

                var s="${it.latitude},${it.longitude}"
                if(name != "a"){
                    s=name
                }
                val apiServices=Network.getRetrofitInstance().create(ApiServices::class.java)
                apiServices.getUserDetails(key, s, days).enqueue(
                    object : Callback<ResponseDTO>{
                        override fun onResponse(call: Call<ResponseDTO>, response: Response<ResponseDTO>) {
                            response.body()?.apply {
                                tempView.text=current?.tempC.toString()
                                locationTextView.text=location?.name
                                humidityShowing.text=current?.humidity.toString()
                                currentMinTemp.text=forecast?.forecastday?.get(0)?.day?.mintempC.toString()
                                currentMaxTemp.text="/"+forecast?.forecastday?.get(0)?.day?.maxtempC.toString()
                                weatherView.text=current?.condition?.text
                                if (current?.isDay==1) {
                                    bgView.setBackgroundResource(R.drawable.sky)
                                }else{
                                    bgView.setBackgroundResource(R.drawable.nightsky)
                                }
                                uvShowing.text=current?.uv.toString()
                                windSpeedShowing.text=current?.windKph.toString()
                                windFromShowing.text=current?.windDir
                                pressureShowing.text=current?.pressureMb.toString()
                                dewPointshowing.text=forecast?.forecastday?.get(0)?.hour?.get(0)?.dewpointC.toString()
                                sunriseshowing.text=forecast?.forecastday?.get(0)?.astro?.sunrise
                                sunsetShowing.text=forecast?.forecastday?.get(0)?.astro?.sunset
                                Glide.with(weatherImageView).load("http:"+current?.condition?.icon).into(weatherImageView)
                            }
                            //hours recyclerView DataFetching
                            hoursDTOList= response.body()?.forecast?.forecastday?.get(0)?.hour as List<HourDTO>
                            setRecyclerView()

                            forecastdayDTOList= response.body()?.forecast?.forecastday as List<ForecastdayDTO>
                            dailySetRecyclerView()
                        }
                        override fun onFailure(call: Call<ResponseDTO>, t: Throwable) {
                            Toast.makeText(context,"Error",Toast.LENGTH_SHORT).show()
                        }

                    }
                )
            }
        }
    }
    private fun setRecyclerView(){
        val adapterClass=HoursAdapter(hoursDTOList)
        hoursRecyclerView.adapter=adapterClass
//        val linearLayoutManager=LinearLayoutManager.HORIZONTAL
        hoursRecyclerView.layoutManager= LinearLayoutManager(context)
        hoursRecyclerView.layoutManager= LinearLayoutManager(context, RecyclerView.HORIZONTAL,false)

    }
    private fun dailySetRecyclerView(){
        val dailyAdapterClass=DailyAdapter(forecastdayDTOList)
        dailyRecyclerView.adapter=dailyAdapterClass
        dailyRecyclerView.layoutManager=LinearLayoutManager(context)

    }
}
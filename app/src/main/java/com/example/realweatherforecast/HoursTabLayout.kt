package com.example.realweatherforecast

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_hours_tab_layout.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HoursTabLayout : Fragment() {

    private var hoursDTOList:List<HourDTO> = listOf()
    private var region=""
    private val key = "5a812faf9e1e4a66b17223056210911"
    private val days = 7

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        region=arguments.toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_hours_tab_layout, container, false)


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        callAPI()
    }

    private fun callAPI() {

        val apiClient=Network.getRetrofitInstance().create(ApiServices::class.java)
        apiClient.getUserDetails(key, region, days).enqueue(
            object : Callback<ResponseDTO> {
                override fun onResponse(call: Call<ResponseDTO>, response: Response<ResponseDTO>) {
                    hoursDTOList= response.body()?.forecast?.forecastday?.get(0)?.hour as List<HourDTO>

                    val adapter = ViewPagerAdapter(hoursDTOList)
                    viewPager.adapter = adapter

                    TabLayoutMediator(tabLayout,viewPager) { tab, position ->
                        tab.text ="Tab ${position + 1} "
                        tabLayout.setBackgroundColor(0)

                    }.attach()

                }

                override fun onFailure(call: Call<ResponseDTO>, t: Throwable) {

                }

            }
        )

    }


}
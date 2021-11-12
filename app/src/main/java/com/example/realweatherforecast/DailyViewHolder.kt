package com.example.realweatherforecast

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.vertical_item_layout.view.*

class DailyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    fun setData(forecastdayDTO: ForecastdayDTO){
        itemView.dailyWeatherView.text=forecastdayDTO.day?.condition?.text
        itemView.dailyDateView.text=forecastdayDTO.date
        itemView.dailyMinTempView.text=forecastdayDTO.day?.mintempC.toString()
        itemView.dailyMaxTemp.text="/"+forecastdayDTO.day?.maxtempC.toString()
        Glide.with(itemView.context).load("http:"+forecastdayDTO.day?.condition?.icon).into(itemView.dailyImageView)
    }

}
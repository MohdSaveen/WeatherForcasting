package com.example.realweatherforecast

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.viewpager_itemlayout.view.*

class ViewPagerViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

    fun setData(hourDTO: HourDTO){

        itemView.feelsLikeShowing.text=hourDTO.feelslikeC.toString()
        itemView.heatIndexShowing.text=hourDTO.heatindexC.toString()
        itemView.dewPointShowing.text=hourDTO.dewpointC.toString()
        itemView.windChillShowing.text=hourDTO.windchillC.toString()
        itemView.windSpeedShowing.text=hourDTO.windKph.toString()
        itemView.gustShowing.text=hourDTO.gustKph.toString()
        itemView.windFromShowing.text=hourDTO.windDir.toString()
        itemView.humidityShowing.text=hourDTO.humidity.toString()
        itemView.pressureShowing.text=hourDTO.pressureMb.toString()
        itemView.visiblityShowing.text=hourDTO.visKm.toString()
        itemView.cloudCoverShowing.text=hourDTO.cloud.toString()
        itemView.chanceOfRainShowing.text=hourDTO.chanceOfRain.toString()
        itemView.dateShowing.text=hourDTO.time
        itemView.pagerTemp.text=hourDTO.tempC.toString()
        itemView.pagerText.text=hourDTO.condition?.text

        Glide.with(itemView.context).load("http://"+hourDTO.condition?.icon).into(itemView.pagerImage)

    }

}
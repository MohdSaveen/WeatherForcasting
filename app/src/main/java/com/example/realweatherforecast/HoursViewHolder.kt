package com.example.realweatherforecast

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.horizontal_item_layout.view.*

class HoursViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {


    fun setData(hourDTO: HourDTO){
        itemView.hoursTimeView.text=hourDTO.time
        itemView.hourstempratureView.text=hourDTO.tempC.toString()
        Glide.with(itemView.context).load("http:"+hourDTO.condition?.icon).into(itemView.hoursImagesView)

    }
}

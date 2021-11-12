package com.example.realweatherforecast

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class DailyAdapter(private val forecastdayDTOList:List<ForecastdayDTO>): RecyclerView.Adapter<DailyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DailyViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.vertical_item_layout,parent,false)
        return DailyViewHolder(view)
    }

    override fun onBindViewHolder(holder: DailyViewHolder, position: Int) {
        val dailyData=forecastdayDTOList[position]
        holder.setData(dailyData)
    }

    override fun getItemCount(): Int {
        return forecastdayDTOList.size
    }
}
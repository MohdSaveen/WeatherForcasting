package com.example.realweatherforecast

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HoursAdapter(private val hourDTOList: List<HourDTO>):RecyclerView.Adapter<HoursViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoursViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.horizontal_item_layout,parent,false)
        return HoursViewHolder(view)
    }

    override fun onBindViewHolder(holder: HoursViewHolder, position: Int) {
        val hoursData=hourDTOList[position]
        holder.setData(hoursData)

    }

    override fun getItemCount(): Int {
        return hourDTOList.size
    }


}
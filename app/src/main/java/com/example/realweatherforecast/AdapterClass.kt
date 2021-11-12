package com.example.realweatherforecast

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AdapterClass(val list: List<ResponseDTO>): RecyclerView.Adapter<ViewHolderClass>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        var view =LayoutInflater.from(parent.context).inflate(R.layout.horizontal_item_layout,parent,false)
        return ViewHolderClass(view)
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {

    }

    override fun getItemCount(): Int {
        return list.size

    }


}
package com.rig.apiendpoint

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class RecyclerAdapter(var entries: List<Entry>) :RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {
    inner class MyViewHolder(v:View):ViewHolder(v){

        var api:TextView
        var des:TextView
        var link:TextView
        var category:TextView

        init {
            api = itemView.findViewById(R.id.api)
            des = itemView.findViewById(R.id.description)
            link = itemView.findViewById(R.id.link)
            category = itemView.findViewById(R.id.category)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recycler_adapter, parent, false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return entries.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.api.text = "API: "+entries[position].API
        holder.des.text = "API: "+entries[position].Description
        holder.link.text =  "Link: "+entries[position].Link
        holder.category.text =  "Category: "+entries[position].Category
    }
}
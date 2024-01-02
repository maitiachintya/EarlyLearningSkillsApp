package com.example.earlylearningskillsapp.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.earlylearningskillsapp.Activity.FlowerActivity
import com.example.earlylearningskillsapp.Modelclass.FlowersImageModel
import com.example.earlylearningskillsapp.R

class FlowerActivityAdapter(val context : FlowerActivity, val flowersitemlists : ArrayList<FlowersImageModel>)
    : RecyclerView.Adapter<FlowerActivityAdapter.FlowerViewHolder>() {

    class FlowerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val alphflower : ImageView = itemView.findViewById(R.id.flowerletteralphabets)
        val imgflower : ImageView = itemView.findViewById(R.id.floweridentitypictures)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlowerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.flowersimageview, parent, false)
        return FlowerViewHolder(view)
    }

    override fun onBindViewHolder(holder: FlowerViewHolder, position: Int) {
        val flowersImageModel : FlowersImageModel = flowersitemlists[position]
        holder.alphflower.setImageResource(flowersImageModel.flowalph)
        holder.imgflower.setImageResource(flowersImageModel.flowimg)
    }

    override fun getItemCount(): Int {
        return flowersitemlists.size
    }
}
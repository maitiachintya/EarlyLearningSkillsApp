package com.example.earlylearningskillsapp.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.earlylearningskillsapp.Activity.BirdsActivity
import com.example.earlylearningskillsapp.Modelclass.BirdsImageModel
import com.example.earlylearningskillsapp.R

class BirdsActivityAdapter(val context : BirdsActivity, val birdslists : ArrayList<BirdsImageModel>)
    : RecyclerView.Adapter<BirdsActivityAdapter.BirdsViewHolder>() {

    class BirdsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textbirds : ImageView = itemView.findViewById(R.id.birdsletter)
        val imgbirds : ImageView = itemView.findViewById(R.id.birdspic)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BirdsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.birdsimageview, parent, false)
        return BirdsViewHolder(view)
    }

    override fun onBindViewHolder(holder: BirdsViewHolder, position: Int) {
        val birdsImageModel : BirdsImageModel = birdslists[position]
        holder.textbirds.setImageResource(birdsImageModel.birdsalphabet)
        holder.imgbirds.setImageResource(birdsImageModel.birdsimg)
    }

    override fun getItemCount(): Int {
        return birdslists.size
    }

}
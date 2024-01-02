package com.example.earlylearningskillsapp.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.earlylearningskillsapp.Activity.FruitsActivity
import com.example.earlylearningskillsapp.Modelclass.FruitsImageModel
import com.example.earlylearningskillsapp.R

class FruitsActivityAdapter(val context : FruitsActivity, var fruitslists : ArrayList<FruitsImageModel>)
    : RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fruitsimageview,parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val fruitsImageModel : FruitsImageModel = fruitslists[position]
        holder.imgalphabet.setImageResource(fruitsImageModel.alphabet)
        holder.img.setImageResource(fruitsImageModel.img)
    }

    override fun getItemCount(): Int {
        return fruitslists.size
    }
}

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val imgalphabet : ImageView = itemView.findViewById(R.id.fruitsletteralphabets)
    val img : ImageView = itemView.findViewById(R.id.fruitsidentitypictures)

}
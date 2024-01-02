package com.example.earlylearningskillsapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.earlylearningskillsapp.Modelclass.NumericImageModel
import com.example.earlylearningskillsapp.R

class NumericActivityAdapter(val context : Context, var numericlist : ArrayList<NumericImageModel>)
    : RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val  view = LayoutInflater.from(parent.context).inflate(R.layout.numericimageview, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val numericImageModel : NumericImageModel = numericlist[position]
        holder.number.setImageResource(numericImageModel.number)
        holder.img.setImageResource(numericImageModel.img)
    }

    override fun getItemCount(): Int {
        return numericlist.size
    }
}

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val number : ImageView = itemView.findViewById(R.id.numericletter)
    val img : ImageView = itemView.findViewById(R.id.numberpic)

}
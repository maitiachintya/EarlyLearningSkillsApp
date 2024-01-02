package com.example.earlylearningskillsapp.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.earlylearningskillsapp.Activity.AnimalsActivity
import com.example.earlylearningskillsapp.Modelclass.AnimalsImageModel
import com.example.earlylearningskillsapp.R

class AnimalsActivityAdapter(val context : AnimalsActivity, var animalslists : ArrayList<AnimalsImageModel>)
    : RecyclerView.Adapter<AnimalsActivityAdapter.DryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalsActivityAdapter.DryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.animalsimageview, parent, false)
        return AnimalsActivityAdapter.DryViewHolder(view)
    }

    override fun onBindViewHolder(holder: AnimalsActivityAdapter.DryViewHolder, position: Int) {
        val animalsImageModel : AnimalsImageModel = animalslists[position]
        holder.alphanimal.setImageResource(animalsImageModel.animalsalphabet)
        holder.imganimal.setImageResource(animalsImageModel.animalsimg)
    }

    override fun getItemCount(): Int {
        return animalslists.size
    }

    class DryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val alphanimal : ImageView = itemView.findViewById(R.id.animalsletter)
        val imganimal : ImageView = itemView.findViewById(R.id.animalspic)
    }
}


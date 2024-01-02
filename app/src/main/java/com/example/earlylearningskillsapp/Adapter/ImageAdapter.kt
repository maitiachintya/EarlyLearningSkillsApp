package com.example.earlylearningskillsapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.earlylearningskillsapp.Modelclass.ImageModel
import com.example.earlylearningskillsapp.OnItemClick
import com.example.earlylearningskillsapp.R

class ImageAdapter(val context: Context, var itemlist :  ArrayList<ImageModel>, val onitemclick : OnItemClick)
    : RecyclerView.Adapter<ImageAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageview: ImageView = itemView.findViewById(R.id.identityimg)
        val constlt: ConstraintLayout = itemView.findViewById(R.id.itemtouch)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.imageview, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val imageModel : ImageModel = itemlist[position]
        holder.imageview.setImageResource(imageModel.img)
        holder.constlt.setOnClickListener {
            onitemclick.onItemClick(position)
        }

    }
        override fun getItemCount(): Int {
            return itemlist.size
        }
    }





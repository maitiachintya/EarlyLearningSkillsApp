package com.example.earlylearningskillsapp.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.earlylearningskillsapp.Modelclass.VegetablesImageModel
import com.example.earlylearningskillsapp.R
import com.example.earlylearningskillsapp.Activity.VegetablesActivity

class VegActivityAdapter(val context : VegetablesActivity, val vegetablesitemlists : ArrayList<VegetablesImageModel>)
    : RecyclerView.Adapter<VegActivityAdapter.VegViewHolder>() {

    class VegViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val alphveg : ImageView = itemView.findViewById(R.id.vegletteralphabets)
        val imgveg : ImageView = itemView.findViewById(R.id.vegidentitypictures)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VegViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.vegetablesimageview, parent, false)
        return VegViewHolder(view)
    }

    override fun onBindViewHolder(holder: VegViewHolder, position: Int) {
        val vegetablesImageModel : VegetablesImageModel = vegetablesitemlists[position]
        holder.alphveg.setImageResource(vegetablesImageModel.vegalph)
        holder.imgveg.setImageResource(vegetablesImageModel.vegimg)
    }

    override fun getItemCount(): Int {
        return vegetablesitemlists.size
    }
}
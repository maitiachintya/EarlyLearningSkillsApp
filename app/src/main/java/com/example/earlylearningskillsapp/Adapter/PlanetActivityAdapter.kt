package com.example.earlylearningskillsapp.Adapter
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.earlylearningskillsapp.Modelclass.PlanetImageModel
import com.example.earlylearningskillsapp.R

class PlanetActivityAdapter(val context : Context, val planetsitemslists : ArrayList<PlanetImageModel>)
    : RecyclerView.Adapter<PlanetActivityAdapter.PlanetViewHolder>(){

    class PlanetViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val alphplanet : ImageView = itemView.findViewById(R.id.planetalphabet)
        val imgplanet : ImageView = itemView.findViewById(R.id.planetidentitypicture)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanetViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.planetimageview, parent, false)
        return PlanetViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlanetViewHolder, position: Int) {
        val planetImageModel : PlanetImageModel = planetsitemslists[position]
        holder.alphplanet.setImageResource(planetImageModel.planetalph)
        holder.imgplanet.setImageResource(planetImageModel.planetimg)
    }

    override fun getItemCount(): Int {
        return planetsitemslists.size
    }
}
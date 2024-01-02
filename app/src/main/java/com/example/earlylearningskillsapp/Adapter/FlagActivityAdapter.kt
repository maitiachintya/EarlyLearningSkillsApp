package com.example.earlylearningskillsapp.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.earlylearningskillsapp.Activity.FlagActivity
import com.example.earlylearningskillsapp.Modelclass.FlagImageModel
import com.example.earlylearningskillsapp.R

class FlagActivityAdapter(val context : FlagActivity, val flagitemslists : ArrayList<FlagImageModel>)
    : RecyclerView.Adapter<FlagActivityAdapter.FlagViewHolder>() {

    class FlagViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val letterflag : ImageView = itemView.findViewById(R.id.flagalphabet)
        val picflag : ImageView = itemView.findViewById(R.id.flagidentitypicture)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlagViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.flagimageview, parent, false)
        return FlagViewHolder(view)
    }

    override fun onBindViewHolder(holder: FlagViewHolder, position: Int) {
        val flagImageModel : FlagImageModel = flagitemslists[position]
        holder.letterflag.setImageResource(flagImageModel.flagalph)
        holder.picflag.setImageResource(flagImageModel.flagpic)
    }

    override fun getItemCount(): Int {
        return flagitemslists.size
    }
}
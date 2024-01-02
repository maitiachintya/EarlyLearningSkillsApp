package com.example.earlylearningskillsapp.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.earlylearningskillsapp.Activity.ShapeActivity
import com.example.earlylearningskillsapp.Modelclass.ShapeImgModel
import com.example.earlylearningskillsapp.R

class ShapeActivityAdapter(val context : ShapeActivity, val shapeitemlists : ArrayList<ShapeImgModel>)
    : RecyclerView.Adapter<ShapeActivityAdapter.ShapeViewHolder>() {

    class ShapeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val shapealph : ImageView = itemView.findViewById(R.id.shapeletteralphabets)
        val shapeimg : ImageView =itemView.findViewById(R.id.shapeidentitypictures)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShapeViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.shapeimageview,parent,false)
        return ShapeViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShapeViewHolder, position: Int) {
       val shapeImgModel : ShapeImgModel = shapeitemlists[position]
        holder.shapealph.setImageResource(shapeImgModel.alphshape)
        holder.shapeimg.setImageResource(shapeImgModel.imgshape)
    }

    override fun getItemCount(): Int {
        return shapeitemlists.size
    }
}
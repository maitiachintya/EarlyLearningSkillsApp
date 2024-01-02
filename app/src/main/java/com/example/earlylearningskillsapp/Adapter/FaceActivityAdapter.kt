package com.example.earlylearningskillsapp.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.earlylearningskillsapp.Activity.FaceActivity
import com.example.earlylearningskillsapp.Modelclass.FaceImageModel
import com.example.earlylearningskillsapp.R

class FaceActivityAdapter(val context : FaceActivity, val faceitemslists : ArrayList<FaceImageModel>)
    : RecyclerView.Adapter<FaceActivityAdapter.FaceViewHolder>() {
    class FaceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val alphabetface : ImageView = itemView.findViewById(R.id.facealphabet)
        val imgface : ImageView = itemView.findViewById(R.id.faceidentitypicture)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FaceViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.faceimageview, parent, false)
        return FaceViewHolder(view)
    }

    override fun onBindViewHolder(holder: FaceViewHolder, position: Int) {
        val faceImageModel : FaceImageModel = faceitemslists[position]
        holder.alphabetface.setImageResource(faceImageModel.alphface)
        holder.imgface.setImageResource(faceImageModel.picface)
    }

    override fun getItemCount(): Int {
        return faceitemslists.size
    }

}
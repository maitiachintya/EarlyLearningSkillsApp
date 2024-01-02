package com.example.earlylearningskillsapp.Adapter
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.earlylearningskillsapp.Modelclass.MusicInstrumentImageModel
import com.example.earlylearningskillsapp.R

class MusicActivityAdapter(val context : Context, val musicsitemslists : ArrayList<MusicInstrumentImageModel>)
    : RecyclerView.Adapter<MusicActivityAdapter.MusicViewHolder>(){

    class MusicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val alphmusic : ImageView = itemView.findViewById(R.id.musicinsalphabet)
        val picmusic : ImageView = itemView.findViewById(R.id.musicinstidentitypicture)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.musicinstrumentimageview, parent, false)
        return MusicViewHolder(view)
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        val musicInstrumentImageModel : MusicInstrumentImageModel = musicsitemslists[position]
        holder.alphmusic.setImageResource(musicInstrumentImageModel.musicalph)
        holder.picmusic.setImageResource(musicInstrumentImageModel.musicpic)
    }

    override fun getItemCount(): Int {
        return musicsitemslists.size
    }
}
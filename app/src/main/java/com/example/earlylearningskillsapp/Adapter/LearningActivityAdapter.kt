package com.example.earlylearningskillsapp

import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.earlylearningskillsapp.Activity.LearnActivity
import com.example.earlylearningskillsapp.Modelclass.LearningImageModel

class LearningActivityAdapter(
    val context: LearnActivity,
    var alphabetlist: ArrayList<LearningImageModel>,
    var mMediaPlayer: MediaPlayer? = null
)
    : RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.alphabetimageview,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       val learningImageModel : LearningImageModel = alphabetlist[position]
        holder.imageView.setImageResource(learningImageModel.img)
        holder.picimageView.setImageResource(learningImageModel.alphabet)
       holder.letterimageview.setImageResource(learningImageModel.imgalphabet)
        /*holder.itemView.setOnClickListener(View.OnClickListener {
            if (mMediaPlayer == null) {
                //mMediaPlayer = MediaPlayer.create(this, R.raw.applesound)
                MediaPlayer.create(holder.itemView.context, R.raw.applesound)
                mMediaPlayer!!.isLooping = false
                mMediaPlayer!!.start()
            } else mMediaPlayer!!.start()



        })*/
        }

    override fun getItemCount(): Int {
        return alphabetlist.size
    }

}

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val imageView : ImageView = itemView.findViewById(R.id.letteralphabet)
    val picimageView : ImageView = itemView.findViewById(R.id.identitypicture)
   val letterimageview :ImageView = itemView.findViewById(R.id.imgletter)
}
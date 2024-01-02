package com.example.earlylearningskillsapp.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.earlylearningskillsapp.Activity.WeekDaysActivity
import com.example.earlylearningskillsapp.Modelclass.WeekDayImageModel
import com.example.earlylearningskillsapp.R

class WeekDayActivityAdapter(val context : WeekDaysActivity, val weekitemslists : ArrayList<WeekDayImageModel>)
    : RecyclerView.Adapter<WeekDayActivityAdapter.WeekDayViewHolder>(){

    class WeekDayViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val weekalph : ImageView = itemView.findViewById(R.id.weekdayalphabet)
        val weekimg : ImageView = itemView.findViewById(R.id.weekdayidentitypicture)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeekDayViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.weekdayimageview, parent, false)
        return WeekDayViewHolder(view)
    }

    override fun onBindViewHolder(holder: WeekDayViewHolder, position: Int) {
        val weekDayImageModel : WeekDayImageModel = weekitemslists[position]
        holder.weekalph.setImageResource(weekDayImageModel.alphabetweek)
        holder.weekimg.setImageResource(weekDayImageModel.imgweek)
    }

    override fun getItemCount(): Int {
        return weekitemslists.size
    }
}
package com.example.earlylearningskillsapp.Activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.earlylearningskillsapp.Adapter.WeekDayActivityAdapter
import com.example.earlylearningskillsapp.Modelclass.WeekDayImageModel
import com.example.earlylearningskillsapp.R

class WeekDaysActivity : AppCompatActivity() {
    var counter = 0
    var weekitemslists = ArrayList<WeekDayImageModel>()
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_week_days)
        recyclerView = findViewById(R.id.weekdayrcvw)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        val myLinearLayoutManager = object : LinearLayoutManager(this) {
            override fun canScrollVertically(): Boolean {
                return false
            }
        }
        recyclerView.layoutManager = myLinearLayoutManager
        weekitemslists.add(WeekDayImageModel(R.drawable.mondayletter, R.drawable.monday))
        weekitemslists.add(WeekDayImageModel(R.drawable.tuesdayletter, R.drawable.tuesday))
        weekitemslists.add(WeekDayImageModel(R.drawable.wednesdayletter, R.drawable.wednesday))
        weekitemslists.add(WeekDayImageModel(R.drawable.thursdayletter, R.drawable.thursday))
        weekitemslists.add(WeekDayImageModel(R.drawable.fridayletter, R.drawable.friday))
        weekitemslists.add(WeekDayImageModel(R.drawable.saturdayletter, R.drawable.saturday))
        weekitemslists.add(WeekDayImageModel(R.drawable.sundayletter, R.drawable.sunday))
        val adapter : WeekDayActivityAdapter = WeekDayActivityAdapter(this, weekitemslists)
        recyclerView.adapter =adapter
        val imghome : ImageView = findViewById(R.id.homesign)
        imghome.setOnClickListener(View.OnClickListener {
            val homeActivityIntent = Intent(this, HomeActivity :: class.java)
            startActivity(homeActivityIntent)
        })
        val leftarrow : ImageView = findViewById(R.id.left_arrow)
        leftarrow.setOnClickListener(View.OnClickListener {
            if(counter != 0){
                counter = counter - 1
                recyclerView.scrollToPosition(counter)
            }
        })
        val rightarrow : ImageView = findViewById(R.id.right_arrow)
        rightarrow.setOnClickListener(View.OnClickListener {
            if(counter<weekitemslists.size){
                counter = counter + 1
                recyclerView.scrollToPosition(counter)
            }
        })
    }
}
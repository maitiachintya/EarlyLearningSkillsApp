package com.example.earlylearningskillsapp.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.earlylearningskillsapp.Adapter.FlagActivityAdapter
import com.example.earlylearningskillsapp.Modelclass.FlagImageModel
import com.example.earlylearningskillsapp.R

class FlagActivity : AppCompatActivity() {
    var counter = 0
    var flagitemslists = ArrayList<FlagImageModel>()
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flag)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        recyclerView = findViewById(R.id.flagitemrcvw)
        val myLinearLayoutManager = object : LinearLayoutManager(this) {
            override fun canScrollVertically(): Boolean {
                return false
            }
        }
        recyclerView.layoutManager = myLinearLayoutManager
       // recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        flagitemslists.add(FlagImageModel(R.drawable.indialetter, R.drawable.flagind))
        flagitemslists.add(FlagImageModel(R.drawable.ukflagletter, R.drawable.ukflag))
        flagitemslists.add(FlagImageModel(R.drawable.germanyletter, R.drawable.germany))
        val adapter : FlagActivityAdapter = FlagActivityAdapter(this, flagitemslists)
        recyclerView.adapter = adapter
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
            if(counter<flagitemslists.size){
                counter = counter + 1
                recyclerView.scrollToPosition(counter)
            }
        })
    }
}
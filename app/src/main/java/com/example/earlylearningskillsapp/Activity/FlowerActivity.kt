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
import com.example.earlylearningskillsapp.Adapter.FlowerActivityAdapter
import com.example.earlylearningskillsapp.Modelclass.FlowersImageModel
import com.example.earlylearningskillsapp.R

class FlowerActivity : AppCompatActivity() {
    var counter = 0
    var flowersitemlists = ArrayList<FlowersImageModel>()
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flower)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        recyclerView = findViewById(R.id.floweritemrcvw)
        val myLinearLayoutManager = object : LinearLayoutManager(this) {
            override fun canScrollVertically(): Boolean {
                return false
            }
        }
        recyclerView.layoutManager = myLinearLayoutManager
        //recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        flowersitemlists.add(FlowersImageModel(R.drawable.roseletter, R.drawable.rose))
        flowersitemlists.add(FlowersImageModel(R.drawable.tulipsletter, R.drawable.tulips))
        flowersitemlists.add(FlowersImageModel(R.drawable.sunflowerletter, R.drawable.sunflower))
        flowersitemlists.add(FlowersImageModel(R.drawable.marrygoldletter, R.drawable.marrygold))
        flowersitemlists.add(FlowersImageModel(R.drawable.orchidletter, R.drawable.orchid))
        flowersitemlists.add(FlowersImageModel(R.drawable.lilyletter, R.drawable.lily))
        flowersitemlists.add(FlowersImageModel(R.drawable.carnationletter, R.drawable.carnation))
        val adapter : FlowerActivityAdapter = FlowerActivityAdapter(this, flowersitemlists)
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
            if(counter<flowersitemlists.size){
                counter = counter + 1
                recyclerView.scrollToPosition(counter)
            }
        })
    }
}
package com.example.earlylearningskillsapp.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.earlylearningskillsapp.Adapter.ShapeActivityAdapter
import com.example.earlylearningskillsapp.Modelclass.ShapeImgModel
import com.example.earlylearningskillsapp.R

class ShapeActivity : AppCompatActivity() {
    var counter = 0
    var shapeitemlists = ArrayList<ShapeImgModel>()
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shape)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        recyclerView = findViewById(R.id.shapeitemrcvw)
        val myLinearLayoutManager = object : LinearLayoutManager(this) {
            override fun canScrollVertically(): Boolean {
                return false
            }
        }
        recyclerView.layoutManager = myLinearLayoutManager
        //recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        shapeitemlists.add(ShapeImgModel(R.drawable.squareletter, R.drawable.square))
        shapeitemlists.add(ShapeImgModel(R.drawable.triangeletter, R.drawable.triangle))
        shapeitemlists.add(ShapeImgModel(R.drawable.rectangleletter, R.drawable.rectangle))
        shapeitemlists.add(ShapeImgModel(R.drawable.pentagonletter, R.drawable.pentagon))
        shapeitemlists.add(ShapeImgModel(R.drawable.rhombusletter, R.drawable.rhombus))
        shapeitemlists.add(ShapeImgModel(R.drawable.starletter, R.drawable.star))
        shapeitemlists.add(ShapeImgModel(R.drawable.pieletter, R.drawable.pie))
        shapeitemlists.add(ShapeImgModel(R.drawable.hexagonletter, R.drawable.hexagon))
        shapeitemlists.add(ShapeImgModel(R.drawable.crescentletter, R.drawable.crescent))
        shapeitemlists.add(ShapeImgModel(R.drawable.elipseletter, R.drawable.elipse))
        val adapter : ShapeActivityAdapter = ShapeActivityAdapter(this, shapeitemlists)
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
            if(counter<shapeitemlists.size){
                counter = counter + 1
                recyclerView.scrollToPosition(counter)
            }
        })
    }
}
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
import com.example.earlylearningskillsapp.Adapter.PlanetActivityAdapter
import com.example.earlylearningskillsapp.Modelclass.PlanetImageModel
import com.example.earlylearningskillsapp.R

class PlanetActivity : AppCompatActivity() {
    var counter = 0
    val planetsitemslists = ArrayList<PlanetImageModel>()
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planet)
        recyclerView = findViewById(R.id.planetrcvw)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        val myLinearLayoutManager = object : LinearLayoutManager(this) {
            override fun canScrollVertically(): Boolean {
                return false
            }
        }
        recyclerView.layoutManager = myLinearLayoutManager
        planetsitemslists.add(PlanetImageModel(R.drawable.mercuryletter, R.drawable.mercury))
        planetsitemslists.add(PlanetImageModel(R.drawable.venusletter, R.drawable.venus))
        planetsitemslists.add(PlanetImageModel(R.drawable.earthletter, R.drawable.earth))
        planetsitemslists.add(PlanetImageModel(R.drawable.marsletter, R.drawable.mars))
        planetsitemslists.add(PlanetImageModel(R.drawable.jupiterletter, R.drawable.jupiter))
        planetsitemslists.add(PlanetImageModel(R.drawable.saturnletter, R.drawable.saturn))
        planetsitemslists.add(PlanetImageModel(R.drawable.uranusletter, R.drawable.uranus))
        planetsitemslists.add(PlanetImageModel(R.drawable.neptuneletter, R.drawable.neptune))
        val adapter : PlanetActivityAdapter = PlanetActivityAdapter(this, planetsitemslists)
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
            if(counter<planetsitemslists.size){
                counter = counter + 1
                recyclerView.scrollToPosition(counter)
            }
        })
    }
}
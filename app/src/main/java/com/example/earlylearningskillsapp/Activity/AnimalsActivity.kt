package com.example.earlylearningskillsapp.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.earlylearningskillsapp.Adapter.AnimalsActivityAdapter
import com.example.earlylearningskillsapp.Modelclass.AnimalsImageModel
import com.example.earlylearningskillsapp.R

class AnimalsActivity : AppCompatActivity() {
    var animalslists = ArrayList<AnimalsImageModel>()
    private lateinit var recyclerView: RecyclerView
    var counter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animals)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        recyclerView = findViewById(R.id.animalsitemrcvw)
        val myLinearLayoutManager = object : LinearLayoutManager(this) {
            override fun canScrollVertically(): Boolean {
                return false
            }
        }
        recyclerView.layoutManager = myLinearLayoutManager
       // recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        animalslists.add(AnimalsImageModel(R.drawable.zebraletter, R.drawable.zebra))
        animalslists.add(AnimalsImageModel(R.drawable.bearletter, R.drawable.bear))
        animalslists.add(AnimalsImageModel(R.drawable.yakletter, R.drawable.yak))
        animalslists.add(AnimalsImageModel(R.drawable.bullletter, R.drawable.bull))
        animalslists.add(AnimalsImageModel(R.drawable.catletter, R.drawable.cat))
        animalslists.add(AnimalsImageModel(R.drawable.cowletter, R.drawable.cow))
        animalslists.add(AnimalsImageModel(R.drawable.crocodileletter, R.drawable.crocodile))
        animalslists.add(AnimalsImageModel(R.drawable.dinosaurletter, R.drawable.dinosour))
        animalslists.add(AnimalsImageModel(R.drawable.dogletter, R.drawable.dog))
        animalslists.add(AnimalsImageModel(R.drawable.elephantletter, R.drawable.elephant))
        animalslists.add(AnimalsImageModel(R.drawable.giraffeletter, R.drawable.giraffe))
        animalslists.add(AnimalsImageModel(R.drawable.horseletter, R.drawable.horse))
        animalslists.add(AnimalsImageModel(R.drawable.kangarooletter, R.drawable.kangaroo))
        animalslists.add(AnimalsImageModel(R.drawable.lionletter, R.drawable.lion))
        val adapter  = AnimalsActivityAdapter(this, animalslists)
        recyclerView.adapter =adapter
        //recyclerView.scrollToPosition(counter)
        val imghome = findViewById<ImageView>(R.id.homesign)
        imghome.setOnClickListener(View.OnClickListener {
            val homeActivity = Intent(this, HomeActivity :: class.java)
            startActivity(homeActivity)
        })
        val leftarrow = findViewById<ImageView>(R.id.left_arrow)
        leftarrow.setOnClickListener(View.OnClickListener {
            if(counter != 0){
                counter = counter - 1
                recyclerView.scrollToPosition(counter)
            }
        })
        val rightarrow = findViewById<ImageView>(R.id.right_arrow)
        rightarrow.setOnClickListener(View.OnClickListener {
            if(counter < animalslists.size){
                counter = counter + 1
                recyclerView.scrollToPosition(counter)
            }
        })
    }
}
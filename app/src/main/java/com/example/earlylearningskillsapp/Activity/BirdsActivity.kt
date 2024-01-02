package com.example.earlylearningskillsapp.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.earlylearningskillsapp.Adapter.BirdsActivityAdapter
import com.example.earlylearningskillsapp.Modelclass.BirdsImageModel
import com.example.earlylearningskillsapp.R

class BirdsActivity : AppCompatActivity() {
    var birdslists = ArrayList<BirdsImageModel>()
    var  counter = 0
    private lateinit var recyclerview : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_birds)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        recyclerview = findViewById(R.id.birdsitemrcvw)
        val myLinearLayoutManager = object : LinearLayoutManager(this) {
            override fun canScrollVertically(): Boolean {
                return false
            }
        }
        recyclerview.layoutManager = myLinearLayoutManager
        //recyclerview.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        birdslists.add(BirdsImageModel(R.drawable.parrotletter, R.drawable.parrot))
        birdslists.add(BirdsImageModel(R.drawable.crowletter, R.drawable.crow))
        birdslists.add(BirdsImageModel(R.drawable.henletter, R.drawable.hen))
        birdslists.add(BirdsImageModel(R.drawable.peacockletter, R.drawable.peacock))
        birdslists.add(BirdsImageModel(R.drawable.pelicanletter, R.drawable.pelican))
        birdslists.add(BirdsImageModel(R.drawable.toucanletter, R.drawable.toucan))
        birdslists.add(BirdsImageModel(R.drawable.vultureletter, R.drawable.vulture))
        birdslists.add(BirdsImageModel(R.drawable.penguinletter, R.drawable.penguin))
        birdslists.add(BirdsImageModel(R.drawable.ostrichletter, R.drawable.ostrich))
        birdslists.add(BirdsImageModel(R.drawable.pigeonletter, R.drawable.pigeon))
        birdslists.add(BirdsImageModel(R.drawable.kingfisherletter, R.drawable.kingfisher))
        birdslists.add(BirdsImageModel(R.drawable.eagleletter, R.drawable.eagle))
        birdslists.add(BirdsImageModel(R.drawable.woodpeckerletter, R.drawable.woodpecker))
        birdslists.add(BirdsImageModel(R.drawable.duckletter, R.drawable.duck))
        birdslists.add(BirdsImageModel(R.drawable.hummingbirdletter, R.drawable.hammingbird))
        birdslists.add(BirdsImageModel(R.drawable.flamingoletter, R.drawable.flamingo))
        birdslists.add(BirdsImageModel(R.drawable.owlletter, R.drawable.owl))
        val adapter : BirdsActivityAdapter = BirdsActivityAdapter(this, birdslists)
        recyclerview.adapter = adapter
        val imghome = findViewById<ImageView>(R.id.homesign)
        imghome.setOnClickListener(View.OnClickListener {
            val homeActivityIntent = Intent(this, HomeActivity :: class.java)
            startActivity(homeActivityIntent)
        })
        val leftarrow : ImageView = findViewById(R.id.left_arrow)
        leftarrow.setOnClickListener(View.OnClickListener {
            if(counter != 0){
                counter = counter - 1
                recyclerview.scrollToPosition(counter)
            }
        })
        val rightarrow : ImageView = findViewById(R.id.right_arrow)
        rightarrow.setOnClickListener(View.OnClickListener {
            if(counter<birdslists.size){
                counter = counter + 1
                recyclerview.scrollToPosition(counter)
            }
        })
    }
}
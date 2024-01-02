package com.example.earlylearningskillsapp.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.earlylearningskillsapp.Adapter.FruitsActivityAdapter
import com.example.earlylearningskillsapp.Modelclass.FruitsImageModel
import com.example.earlylearningskillsapp.R

class FruitsActivity : AppCompatActivity() {
    var fruitslists = ArrayList<FruitsImageModel>()
    var counter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fruits)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        val recyclerView = findViewById<RecyclerView>(R.id.itemrcvw)
        val myLinearLayoutManager = object : LinearLayoutManager(this) {
            override fun canScrollVertically(): Boolean {
                return false
            }
        }
        recyclerView.layoutManager = myLinearLayoutManager
        //recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        fruitslists.add(FruitsImageModel(R.drawable.appleletter, R.drawable.apple))
        fruitslists.add(FruitsImageModel(R.drawable.bananaletter, R.drawable.banana))
        fruitslists.add(FruitsImageModel(R.drawable.cherryletter, R.drawable.cherry))
        fruitslists.add(FruitsImageModel(R.drawable.strawberryletter, R.drawable.strawberrypic))
        fruitslists.add(FruitsImageModel(R.drawable.pearletter, R.drawable.pear))
        fruitslists.add(FruitsImageModel(R.drawable.grapesletter, R.drawable.grapes))
        fruitslists.add(FruitsImageModel(R.drawable.guavaletter, R.drawable.guava))
        fruitslists.add(FruitsImageModel(R.drawable.pomegranateletter, R.drawable.pomegranate))
        fruitslists.add(FruitsImageModel(R.drawable.lemonletter, R.drawable.lemon))
        fruitslists.add(FruitsImageModel(R.drawable.quinceletter, R.drawable.quince))
        fruitslists.add(FruitsImageModel(R.drawable.watermelonletter, R.drawable.watermelon))
        fruitslists.add(FruitsImageModel(R.drawable.mangoletter, R.drawable.mango))
        fruitslists.add(FruitsImageModel(R.drawable.pineappleletter, R.drawable.pineapple))
        fruitslists.add(FruitsImageModel(R.drawable.kiwiletter, R.drawable.kiwi))
        fruitslists.add(FruitsImageModel(R.drawable.dragonfruitletter, R.drawable.dragonfruit))
        fruitslists.add(FruitsImageModel(R.drawable.plumletter, R.drawable.plum))
        fruitslists.add(FruitsImageModel(R.drawable.coconutletter, R.drawable.coconut))
        fruitslists.add(FruitsImageModel(R.drawable.papayaletter, R.drawable.papaya))
        fruitslists.add(FruitsImageModel(R.drawable.orangeletter, R.drawable.orange))
        val adapter : FruitsActivityAdapter = FruitsActivityAdapter(this, fruitslists)
        recyclerView.adapter = adapter
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
            if(counter < fruitslists.size){
                counter = counter + 1
                recyclerView.scrollToPosition(counter)
            }
        })
    }
}
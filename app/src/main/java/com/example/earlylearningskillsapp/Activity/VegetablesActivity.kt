package com.example.earlylearningskillsapp.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.earlylearningskillsapp.Adapter.VegActivityAdapter
import com.example.earlylearningskillsapp.Modelclass.VegetablesImageModel
import com.example.earlylearningskillsapp.R

class VegetablesActivity : AppCompatActivity() {
    var vegetablesitemlists = ArrayList<VegetablesImageModel>()
    var counter = 0
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vegetables)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        recyclerView = findViewById(R.id.vegitemrcvw)
        val myLinearLayoutManager = object : LinearLayoutManager(this) {
            override fun canScrollVertically(): Boolean {
                return false
            }
        }
        recyclerView.layoutManager = myLinearLayoutManager
        //recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        vegetablesitemlists.add(VegetablesImageModel(R.drawable.potatoletter, R.drawable.potato))
        vegetablesitemlists.add(VegetablesImageModel(R.drawable.carrotletter, R.drawable.carrot))
        vegetablesitemlists.add(VegetablesImageModel(R.drawable.brinjalletter, R.drawable.brinjal))
        vegetablesitemlists.add(VegetablesImageModel(R.drawable.tomatoletter, R.drawable.tomato))
        vegetablesitemlists.add(VegetablesImageModel(R.drawable.onionletter, R.drawable.onion))
        vegetablesitemlists.add(VegetablesImageModel(R.drawable.radishletter, R.drawable.radish))
        vegetablesitemlists.add(VegetablesImageModel(R.drawable.capsicumletter, R.drawable.capsicum))
        vegetablesitemlists.add(VegetablesImageModel(R.drawable.cornletter, R.drawable.corn))
        vegetablesitemlists.add(VegetablesImageModel(R.drawable.cauliflowerletter, R.drawable.cauliflower))
        vegetablesitemlists.add(VegetablesImageModel(R.drawable.cucumberletter, R.drawable.cucumber))
        vegetablesitemlists.add(VegetablesImageModel(R.drawable.cabbageletter, R.drawable.cabbage))
        vegetablesitemlists.add(VegetablesImageModel(R.drawable.ladiesfingerletter, R.drawable.ladiesfinger))
        vegetablesitemlists.add(VegetablesImageModel(R.drawable.beetletter, R.drawable.beet))
        vegetablesitemlists.add(VegetablesImageModel(R.drawable.pumpkinletter, R.drawable.pumkin))
        vegetablesitemlists.add(VegetablesImageModel(R.drawable.mushroomletter, R.drawable.mushroom))
        vegetablesitemlists.add(VegetablesImageModel(R.drawable.peasletter, R.drawable.peas))
        val adapter : VegActivityAdapter = VegActivityAdapter(this, vegetablesitemlists)
        recyclerView.adapter = adapter
        val imghome = findViewById<ImageView>(R.id.homesign)
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
            if(counter<vegetablesitemlists.size){
                counter = counter + 1
                recyclerView.scrollToPosition(counter)
            }
        })
    }
}
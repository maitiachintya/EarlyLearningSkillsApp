package com.example.earlylearningskillsapp.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.earlylearningskillsapp.Adapter.NumericActivityAdapter
import com.example.earlylearningskillsapp.Modelclass.NumericImageModel
import com.example.earlylearningskillsapp.R
import com.example.earlylearningskillsapp.R.id.numericitemrcvw

class NumericActivity : AppCompatActivity() {
    var counter = 0
    var numericlists = ArrayList<NumericImageModel>()
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_numeric)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        recyclerView = findViewById(numericitemrcvw)
        val myLinearLayoutManager = object : LinearLayoutManager(this) {
            override fun canScrollVertically(): Boolean {
                return false
            }
        }
        recyclerView.layoutManager = myLinearLayoutManager
      //  recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        numericlists.add(NumericImageModel(R.drawable.zeroletter, R.drawable.zero))
        numericlists.add(NumericImageModel(R.drawable.oneletter, R.drawable.pineapple))
        numericlists.add(NumericImageModel(R.drawable.twoletter, R.drawable.twobananas))
        numericlists.add(NumericImageModel(R.drawable.threeletter, R.drawable.pumkin))
        numericlists.add(NumericImageModel(R.drawable.four, R.drawable.fourapples))
        numericlists.add(NumericImageModel(R.drawable.fiveletter, R.drawable.carrots))
        numericlists.add(NumericImageModel(R.drawable.sixletters, R.drawable.cauliflowers))
        numericlists.add(NumericImageModel(R.drawable.sevenletter, R.drawable.sevenpic))
        numericlists.add(NumericImageModel(R.drawable.eightletters, R.drawable.people))
        numericlists.add(NumericImageModel(R.drawable.nineletter, R.drawable.waves))
        numericlists.add(NumericImageModel(R.drawable.tenletter, R.drawable.ten))
        numericlists.add(NumericImageModel(R.drawable.elevenletter, R.drawable.eleven))
        numericlists.add(NumericImageModel(R.drawable.twelveletter, R.drawable.twelve))
        numericlists.add(NumericImageModel(R.drawable.thirteenletter, R.drawable.thirteen))
        numericlists.add(NumericImageModel(R.drawable.fourteenletter, R.drawable.fourteen))
        numericlists.add(NumericImageModel(R.drawable.fifteenletter, R.drawable.fifteen))
        numericlists.add(NumericImageModel(R.drawable.sixteenletter, R.drawable.sixteen))
        numericlists.add(NumericImageModel(R.drawable.seventeenletter, R.drawable.seventeen))
        val adapter : NumericActivityAdapter = NumericActivityAdapter(this, numericlists)
        recyclerView.adapter = adapter
        val imghome = findViewById<ImageView>(R.id.homesign)
        imghome.setOnClickListener(View.OnClickListener {
            val homeActivity = Intent(this, HomeActivity :: class.java)
            startActivity(homeActivity)
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
            if(counter<numericlists.size){
                counter = counter + 1
                recyclerView.scrollToPosition(counter)
            }
        })
    }
}
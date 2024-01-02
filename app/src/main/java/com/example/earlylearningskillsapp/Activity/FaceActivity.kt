package com.example.earlylearningskillsapp.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.earlylearningskillsapp.Adapter.FaceActivityAdapter
import com.example.earlylearningskillsapp.Modelclass.FaceImageModel
import com.example.earlylearningskillsapp.R

class FaceActivity : AppCompatActivity() {
    var counter = 0
    var faceitemlists = ArrayList<FaceImageModel>()
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_face)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        recyclerView = findViewById(R.id.faceitemrcvw)
        val myLinearLayoutManager = object : LinearLayoutManager(this){
                override fun canScrollVertically(): Boolean {
                    return false
            }
        }
        recyclerView.layoutManager = myLinearLayoutManager
        faceitemlists.add(FaceImageModel(R.drawable.faceletter, R.drawable.facepic))
        faceitemlists.add(FaceImageModel(R.drawable.eyeletter, R.drawable.eye))
        faceitemlists.add(FaceImageModel(R.drawable.earletter, R.drawable.ear))
        faceitemlists.add(FaceImageModel(R.drawable.noseletter, R.drawable.nose))
        faceitemlists.add(FaceImageModel(R.drawable.lipletter, R.drawable.lips))
        faceitemlists.add(FaceImageModel(R.drawable.armletter, R.drawable.arm))
        faceitemlists.add(FaceImageModel(R.drawable.handletter, R.drawable.hand))
        val adapter : FaceActivityAdapter = FaceActivityAdapter(this,faceitemlists)
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
            if(counter<faceitemlists.size){
                counter = counter + 1
                recyclerView.scrollToPosition(counter)
            }
        })
    }
}
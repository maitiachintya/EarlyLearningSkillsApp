package com.example.earlylearningskillsapp.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.earlylearningskillsapp.LearningActivityAdapter
import com.example.earlylearningskillsapp.Modelclass.LearningImageModel
import com.example.earlylearningskillsapp.R

class LearnActivity : AppCompatActivity() {
    var counter = 0
    var alphabetlist = ArrayList<LearningImageModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learn)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        val recyclerView = findViewById<RecyclerView>(R.id.recycleimage)
        val myLinearLayoutManager = object : LinearLayoutManager(this) {
            override fun canScrollVertically(): Boolean {
                return false
            }
        }
        recyclerView.layoutManager = myLinearLayoutManager
       // recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        alphabetlist.add(LearningImageModel(R.drawable.a, R.drawable.appleletter, R.drawable.apple))
        alphabetlist.add(LearningImageModel(R.drawable.b, R.drawable.ballletter, R.drawable.ball))
        alphabetlist.add(LearningImageModel(R.drawable.c, R.drawable.catletter, R.drawable.cat))
        alphabetlist.add(LearningImageModel(R.drawable.d, R.drawable.dogletter, R.drawable.dog))
        alphabetlist.add(LearningImageModel(R.drawable.e, R.drawable.elephantletter, R.drawable.elephant))
        alphabetlist.add(LearningImageModel(R.drawable.f, R.drawable.flagletter, R.drawable.flag))
        alphabetlist.add(LearningImageModel(R.drawable.g, R.drawable.goatletter, R.drawable.goat))
        alphabetlist.add(LearningImageModel(R.drawable.h, R.drawable.henletter, R.drawable.hen))
        alphabetlist.add(LearningImageModel(R.drawable.i, R.drawable.icecreamletter, R.drawable.icecream))
        alphabetlist.add(LearningImageModel(R.drawable.j, R.drawable.jugletter, R.drawable.jug))
        alphabetlist.add(LearningImageModel(R.drawable.k, R.drawable.kiteletter, R.drawable.kite))
        alphabetlist.add(LearningImageModel(R.drawable.l, R.drawable.lampletter, R.drawable.lamp))
        alphabetlist.add(LearningImageModel(R.drawable.m, R.drawable.mangoletter, R.drawable.mango))
        alphabetlist.add(LearningImageModel(R.drawable.n, R.drawable.nestletter, R.drawable.nest))
        alphabetlist.add(LearningImageModel(R.drawable.o, R.drawable.orangeletter, R.drawable.orange))
        alphabetlist.add(LearningImageModel(R.drawable.p, R.drawable.parrotletter, R.drawable.parrot))
        alphabetlist.add(LearningImageModel(R.drawable.q, R.drawable.queenletter, R.drawable.queen))
        alphabetlist.add(LearningImageModel(R.drawable.r, R.drawable.roseletter, R.drawable.rose))
        alphabetlist.add(LearningImageModel(R.drawable.s, R.drawable.snakeletter, R.drawable.snake))
        alphabetlist.add(LearningImageModel(R.drawable.t, R.drawable.tableletter, R.drawable.table))
        alphabetlist.add(LearningImageModel(R.drawable.u, R.drawable.umbrellaletter, R.drawable.umbrella))
        alphabetlist.add(LearningImageModel(R.drawable.v, R.drawable.vultureletter, R.drawable.vulture))
        alphabetlist.add(LearningImageModel(R.drawable.w, R.drawable.wristwatchleter, R.drawable.wristwatch))
        alphabetlist.add(LearningImageModel(R.drawable.x, R.drawable.xylophoneletter, R.drawable.xylophone))
        alphabetlist.add(LearningImageModel(R.drawable.y, R.drawable.yakletter, R.drawable.yak))
        alphabetlist.add(LearningImageModel(R.drawable.z, R.drawable.zebraletter, R.drawable.zebra))
        val adapter : LearningActivityAdapter = LearningActivityAdapter(this,alphabetlist)
        recyclerView.adapter = adapter
        val imghome = findViewById<ImageView>(R.id.homesign)
        imghome.setOnClickListener(View.OnClickListener {
            val homeactivity = Intent(this, HomeActivity::class.java)
            startActivity(homeactivity)
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
            if(counter<alphabetlist.size){
                counter = counter + 1
                recyclerView.scrollToPosition(counter)
            }
        })
    }
}
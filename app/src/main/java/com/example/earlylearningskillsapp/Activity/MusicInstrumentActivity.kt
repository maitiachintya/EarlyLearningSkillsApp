package com.example.earlylearningskillsapp.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.earlylearningskillsapp.Adapter.MusicActivityAdapter
import com.example.earlylearningskillsapp.Modelclass.MusicInstrumentImageModel
import com.example.earlylearningskillsapp.R

class MusicInstrumentActivity : AppCompatActivity() {
    var counter = 0
    var musicsitemslists = ArrayList<MusicInstrumentImageModel>()
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music_instrument)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        recyclerView = findViewById(R.id.musicinstitemrcvw)
        val myLinearLayoutManager = object : LinearLayoutManager(this){
            override fun canScrollVertically(): Boolean {
                return false
            }
        }
        recyclerView.layoutManager = myLinearLayoutManager
        musicsitemslists.add(MusicInstrumentImageModel(R.drawable.guiterletter, R.drawable.guitar))
        musicsitemslists.add(MusicInstrumentImageModel(R.drawable.harmoniumletter, R.drawable.harmonium))
        musicsitemslists.add(MusicInstrumentImageModel(R.drawable.drumletter, R.drawable.drum))
        musicsitemslists.add(MusicInstrumentImageModel(R.drawable.saxophoneletter, R.drawable.saxophone))
        musicsitemslists.add(MusicInstrumentImageModel(R.drawable.bagpipeletter, R.drawable.bagpipe))
        musicsitemslists.add(MusicInstrumentImageModel(R.drawable.xylophoneletter, R.drawable.xylophone))
        musicsitemslists.add(MusicInstrumentImageModel(R.drawable.tambourineletter, R.drawable.tambourine))
        musicsitemslists.add(MusicInstrumentImageModel(R.drawable.accordionletter, R.drawable.accordion))
        musicsitemslists.add(MusicInstrumentImageModel(R.drawable.banjoletter, R.drawable.banjo))
        musicsitemslists.add(MusicInstrumentImageModel(R.drawable.congaletter, R.drawable.conga))
        musicsitemslists.add(MusicInstrumentImageModel(R.drawable.gongletter, R.drawable.gong))
        musicsitemslists.add(MusicInstrumentImageModel(R.drawable.whistleletter, R.drawable.whistle))
        musicsitemslists.add(MusicInstrumentImageModel(R.drawable.violinletter, R.drawable.violin))
        musicsitemslists.add(MusicInstrumentImageModel(R.drawable.fluteletter, R.drawable.flute))
        musicsitemslists.add(MusicInstrumentImageModel(R.drawable.trumpetletter,R.drawable.trumpet))
        musicsitemslists.add(MusicInstrumentImageModel(R.drawable.harpletter, R.drawable.harp))
        musicsitemslists.add(MusicInstrumentImageModel(R.drawable.sitarletter, R.drawable.sitar))
        val adapter : MusicActivityAdapter = MusicActivityAdapter(this, musicsitemslists)
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
            if(counter<musicsitemslists.size){
                counter = counter + 1
                recyclerView.scrollToPosition(counter)
            }
        })
    }
}
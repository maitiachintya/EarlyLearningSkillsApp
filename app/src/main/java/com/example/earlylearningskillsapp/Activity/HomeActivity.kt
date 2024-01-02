package com.example.earlylearningskillsapp.Activity

import android.content.Intent
import android.content.SharedPreferences
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import android.view.WindowManager
import android.widget.ImageButton
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.earlylearningskillsapp.*
import com.example.earlylearningskillsapp.Adapter.ImageAdapter
import com.example.earlylearningskillsapp.Modelclass.ImageModel
import com.example.earlylearningskillsapp.singlatonclass.SharedPreferenceManager
import com.example.earlylearningskillsapp.utils.Constance

class HomeActivity : AppCompatActivity() {
    var counter = 0
    var itemlist =  ArrayList<ImageModel>()
    private lateinit var sharedPreferences : SharedPreferences
     //lateinit var path : Path
     private lateinit var recyclerView : RecyclerView
      //var a : String ="hghjg"
    var ismusicplayer: Boolean = false
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var imageButton: ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
         recyclerView = findViewById(R.id.recycleimg)
        sharedPreferences =  PreferenceManager.getDefaultSharedPreferences(this)
       val mylayOutManager= GridLayoutManager(this,2)
        recyclerView.layoutManager = mylayOutManager
        mediaPlayer = MediaPlayer.create(this, R.raw.audiotune)
        itemlist.add(ImageModel(R.drawable.mspaintlogo))
        itemlist.add(ImageModel(R.drawable.alphabetlogo))
        itemlist.add(ImageModel(R.drawable.quizlogo))
        itemlist.add(ImageModel(R.drawable.headphone))
        itemlist.add(ImageModel(R.drawable.fruits))
        itemlist.add(ImageModel(R.drawable.numericdig))
        itemlist.add(ImageModel(R.drawable.animal))
        itemlist.add(ImageModel(R.drawable.birdslogo))
        itemlist.add(ImageModel(R.drawable.vegetables))
        itemlist.add(ImageModel(R.drawable.shapes))
        itemlist.add(ImageModel(R.drawable.flagicon))
        itemlist.add(ImageModel(R.drawable.face))
        itemlist.add(ImageModel(R.drawable.flower))
        itemlist.add(ImageModel(R.drawable.musicinstruments))
        itemlist.add(ImageModel(R.drawable.globes))
        itemlist.add(ImageModel(R.drawable.calendar))

        val adapter : ImageAdapter = ImageAdapter(this,itemlist, object : OnItemClick {
            override fun onItemClick(pos: Int) {
               // Toast.makeText(this@HomeActivity,pos.toString(),Toast.LENGTH_LONG).show()
             //   counter = pos
                if(pos == 0){
                    val paintActivity = Intent(this@HomeActivity, PaintActivity :: class.java)
                    startActivity(paintActivity)
                }
                if(pos == 1) {
                    if (sharedPreferences.getBoolean(Constance.ISLOGIN, false)) {
                        val learnActivityIntent = Intent(this@HomeActivity, LearnActivity::class.java)
                        startActivity(learnActivityIntent)
                    }
                    else{
                        val loginActivityIntent = Intent(this@HomeActivity, LoginActivity::class.java)
                        startActivity(loginActivityIntent)
                    }
                }
                if(pos == 2){
                   // SharedPreferenceManager.getInstance(this@HomeActivity).getValue(Constance.ISLOGIN,"")

                    if(sharedPreferences.getBoolean(Constance.ISLOGIN, false)){
                        val quizActivityIntent = Intent(this@HomeActivity, QuizActivity :: class.java)
                        startActivity(quizActivityIntent)
                    }
                    else{
                        val loginActivityIntent = Intent(this@HomeActivity, LoginActivity :: class.java)
                        startActivity(loginActivityIntent)
                    }
                }
                if(pos == 4){
                    val fruitsActivity = Intent(this@HomeActivity, FruitsActivity :: class.java)
                    startActivity(fruitsActivity)
                }
                if(pos == 5){
                    val numericActivity = Intent(this@HomeActivity, NumericActivity :: class.java)
                    startActivity(numericActivity)
                }
                if (pos == 6){
                    val animalsActivity =   Intent(this@HomeActivity, AnimalsActivity :: class.java)
                    startActivity(animalsActivity)
                }
                if(pos == 7){
                    val birdsActivity = Intent(this@HomeActivity, BirdsActivity :: class.java)
                    startActivity(birdsActivity)
                }
                if(pos == 8){
                    val vegetablesActivityIntent = Intent(this@HomeActivity, VegetablesActivity :: class.java)
                    startActivity(vegetablesActivityIntent)
                }
                if(pos == 9) {
                    val shapeActivityIntent = Intent(this@HomeActivity, ShapeActivity::class.java)
                    startActivity(shapeActivityIntent)
                }
                if(pos == 10){
                    val flagActivityIntent = Intent(this@HomeActivity, FlagActivity :: class.java)
                    startActivity(flagActivityIntent)
                }
                if(pos == 11){
                    val faceActivityIntent = Intent(this@HomeActivity, FaceActivity :: class.java)
                    startActivity(faceActivityIntent)
                }
                if(pos == 12){
                    val flowerActivityIntent = Intent(this@HomeActivity, FlowerActivity :: class.java)
                    startActivity(flowerActivityIntent)
                }
                if(pos == 13){
                    val musicActivityIntent = Intent(this@HomeActivity, MusicInstrumentActivity :: class.java)
                    startActivity(musicActivityIntent)
                }
                if(pos == 14){
                    val planetActivityIntent = Intent(this@HomeActivity, PlanetActivity :: class.java)
                    startActivity(planetActivityIntent)
                }
                if(pos == 15){
                    val weekDaysActivityIntent = Intent(this@HomeActivity, WeekDaysActivity :: class.java)
                    startActivity(weekDaysActivityIntent)
                }
            }
        })
        recyclerView.adapter = adapter
       val imageButton = findViewById<ImageButton>(R.id.spklg)
        imageButton.setOnClickListener(View.OnClickListener {
            if(ismusicplayer == false){
                mediaPlayer.start()
                ismusicplayer = true
                imageButton.setBackgroundResource(R.drawable.speakerlogo)
            }
            else if(ismusicplayer == true){
                mediaPlayer.pause();
                ismusicplayer = false;
                imageButton.setBackgroundResource(R.drawable.speakerlogo);
            }
        })

        val uparrow : ImageView = findViewById(R.id.arrowup)
        uparrow.setOnClickListener(View.OnClickListener {
            counter = mylayOutManager.findFirstCompletelyVisibleItemPosition() - 4
            recyclerView.scrollToPosition(counter)
        })
        val downarrow : ImageView = findViewById(R.id.arrowsign)
        downarrow.setOnClickListener(View.OnClickListener {
          //  if(counter != 0){
             //   counter = counter - 1
                counter = mylayOutManager.findLastCompletelyVisibleItemPosition() +4
                recyclerView.scrollToPosition(counter)

           // }
        })
    }

    private fun isSharedPreference() {
        TODO("Not yet implemented")
    }

    override fun onPause() {
        super.onPause()
        if(mediaPlayer.isPlaying())
            mediaPlayer.pause();
    }
}
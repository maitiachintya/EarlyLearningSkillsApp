package com.example.earlylearningskillsapp.Activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.RatingBar
import android.widget.TextView
import com.example.earlylearningskillsapp.R

class ScoreActivity : AppCompatActivity() {
    private lateinit var ratingBar : RatingBar
    lateinit var feedbacktext : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        val  c : Int = intent.getIntExtra("score",0)
        val scoretext = findViewById<TextView>(R.id.scoretext)
        ratingBar = findViewById(R.id.no_ofstars)
        ratingBar.setOnRatingBarChangeListener(RatingBar.OnRatingBarChangeListener { ratingBar, rating, b ->
          //  updateFeedbackMessage(rating.toInt())
        })
        feedbacktext = findViewById(R.id.fdbck)
        val bundle = intent.extras
       // val receivedScored = bundle?.getInt("score")?: 0
        if (c>9 && c <= 12) {
            scoretext.setText("Your Result is "+c.toString())
            ratingBar.rating = c.toFloat()
            feedbacktext.text =  getString(R.string.excellent_msg)
            feedbacktext.textColors.defaultColor
        } else if (c > 7 && c <= 9) {
            scoretext.setText("Your Result is "+c.toString())
            ratingBar.rating = c.toFloat()
            feedbacktext.text =  getString(R.string.good_msg)
        } else if (c >= 3 && c <= 7) {
            scoretext.setText("Your Result is "+c.toString())
            ratingBar.rating = c.toFloat()
            feedbacktext.text =  getString(R.string.keep_up_msg)
        } else {
            scoretext.setText("Your Result is "+c.toString())
            ratingBar.rating = c.toFloat()

            feedbacktext.text = getString(R.string.try_again_msg)
        }
    }
    private fun updateFeedbackMessage(rating: Int) {
        val feedbackMessage = when (rating) {
            1 -> "Very Poor"
            2 -> "Poor"
            3 -> "Okay"
            4 -> "Good"
            5 -> "Excellent"
            else -> "Please provide a rating"
        }
        feedbacktext.text = feedbackMessage
    }
}
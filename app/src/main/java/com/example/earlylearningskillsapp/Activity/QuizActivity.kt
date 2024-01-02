package com.example.earlylearningskillsapp.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.earlylearningskillsapp.Adapter.QuizActivityAdapter
import com.example.earlylearningskillsapp.Modelclass.QuizImageModel
import com.example.earlylearningskillsapp.R

class QuizActivity : AppCompatActivity() {
    var score = 0
    private lateinit var startButton: Button
    private lateinit var timerTextView: TextView
    var quizitemlists = ArrayList<QuizImageModel>()
    private var countdownTimer: CountDownTimer? = null
    private var isTimerRunning = false
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        startButton = findViewById(R.id.startButton)
        timerTextView = findViewById(R.id.timerTextView)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        recyclerView = findViewById(R.id.quizitemrcvw)
        startButton.setOnClickListener(View.OnClickListener {
            if (!isTimerRunning) {
                startTimer()
                startButton.text = "Stop Timer"
            } else {
                stopTimer()
                startButton.text = "Start Timer"
            }
        })
        val myLinearLayoutManager = object : LinearLayoutManager(this) {
            override fun canScrollVertically(): Boolean {
                return false
            }
        }
        recyclerView.layoutManager = myLinearLayoutManager
       // recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        quizitemlists.add(QuizImageModel(R.drawable.papayaletter,R.drawable.lion, R.drawable.papaya, R.drawable.dog,2))
        quizitemlists.add(QuizImageModel(R.drawable.appleletter, R.drawable.pear, R.drawable.apple, R.drawable.pomegranate,2))
        quizitemlists.add(QuizImageModel(R.drawable.ballletter, R.drawable.ball, R.drawable.banana, R.drawable.zebra,1))
        quizitemlists.add(QuizImageModel(R.drawable.catletter, R.drawable.kite, R.drawable.mango, R.drawable.cat,3))
        quizitemlists.add(QuizImageModel(R.drawable.flagletter, R.drawable.flag, R.drawable.coconut, R.drawable.pineapple,1))
        quizitemlists.add(QuizImageModel(R.drawable.seventeenletter, R.drawable.orange, R.drawable.kangaroo, R.drawable.seventeen,3))
        quizitemlists.add(QuizImageModel(R.drawable.helicopterletter, R.drawable.vulture, R.drawable.icecream,  R.drawable.helicopter,3))
        quizitemlists.add(QuizImageModel(R.drawable.carletter, R.drawable.quince, R.drawable.car, R.drawable.sevenpic,2))
        quizitemlists.add(QuizImageModel(R.drawable.dinosaurletter, R.drawable.dinosour, R.drawable.birdslogo, R.drawable.nest,1))
        quizitemlists.add(QuizImageModel(R.drawable.lampletter, R.drawable.queen, R.drawable.lamp, R.drawable.rose,2))
        quizitemlists.add(QuizImageModel(R.drawable.snakeletter, R.drawable.crocodile, R.drawable.lion, R.drawable.snake,3))
        quizitemlists.add(QuizImageModel(R.drawable.parrotletter, R.drawable.parrot, R.drawable.bull, R.drawable.pumkin,1))
        val adapter : QuizActivityAdapter = QuizActivityAdapter(this, quizitemlists,score,recyclerView)
        recyclerView.adapter = adapter
    }

    private fun stopTimer() {
        countdownTimer?.cancel()
        isTimerRunning = false
        timerTextView.text = "Timer Stopped"
    }

    private fun startTimer() {
        countdownTimer = object : CountDownTimer(60000, 1000) { // 60 seconds countdown
            override fun onTick(millisUntilFinished: Long) {
                val secondsRemaining = millisUntilFinished / 1000
                timerTextView.text = "Time Remaining: $secondsRemaining seconds"
            }

            override fun onFinish() {
                timerTextView.text = "Timer Finished"
                isTimerRunning = false
                startButton.text = "Start Timer"
            }
        }
        countdownTimer?.start()
        isTimerRunning = true
    }
}
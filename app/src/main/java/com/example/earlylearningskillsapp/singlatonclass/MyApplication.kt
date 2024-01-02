package com.example.earlylearningskillsapp.singlatonclass

import android.app.Application
import com.example.earlylearningskillsapp.utils.Constance

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        SharedPreferenceManager.getInstance(this).getValue(Constance.ISLOGIN,"")
    }
}
package com.example.earlylearningskillsapp.singlatonclass

import android.content.Context
import android.content.SharedPreferences

class SharedPreferenceManager private constructor(context : Context){
    private val sharedPreferences : SharedPreferences = context.getSharedPreferences("MyAppPreferences", Context.MODE_PRIVATE)
    companion object{
        private var instance : SharedPreferenceManager ?= null
        @Synchronized
        fun getInstance(context: Context) : SharedPreferenceManager{
            if(instance == null){
                instance = SharedPreferenceManager(context)
            }
            return instance !!
        }
    }
    fun setValue(key : String, value : String){
        sharedPreferences.edit().putString(key, value).commit()
        sharedPreferences.edit().apply()
    }
    fun getValue(key: String, defaultValue : String) : String{
        return sharedPreferences.getString(key, defaultValue) ?: defaultValue
    }
    // Save data
    /*val sharedPrefs = SharedPreferenceManager.getInstance(context)
    sharedPrefs.saveString("username", "john_doe")

    // Retrieve data
    val username = sharedPrefs.getString("username", "")*/
}
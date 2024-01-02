package com.example.earlylearningskillsapp.Activity

import android.content.Intent
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.earlylearningskillsapp.R
import com.example.earlylearningskillsapp.utils.Constance

class LoginActivity : AppCompatActivity() {
    private lateinit var sharedPreference : SharedPreferences
    private lateinit var editor : Editor
    private lateinit var name : EditText
    private lateinit var password : EditText
    private lateinit var button : Button
    private lateinit var checkBox : CheckBox
    private lateinit var strName : String
    private lateinit var strPassword : String
    private lateinit var strCheckBox: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        name = findViewById(R.id.et_username)
        password = findViewById(R.id.et_password)
        button = findViewById(R.id.btn_login)
        checkBox = findViewById(R.id.chk_bx)
        sharedPreference = PreferenceManager.getDefaultSharedPreferences(this)
        editor = sharedPreference.edit()
        checkSharedPreference()
        button.setOnClickListener(View.OnClickListener {
            if(isFormat()) {
                editor.putBoolean(Constance.ISLOGIN, true)
                editor.commit()
                if (checkBox.isChecked) {
                    strName = name.text.toString()
                    editor.putString(getString(R.string.name), strName)
                    editor.commit()
                    strPassword = password.text.toString()
                    editor.putString(getString(R.string.password), strPassword)
                    editor.commit()
                    editor.apply()

                   // val learnActivityIntent = Intent(this, LearnActivity::class.java)
                   // startActivity(learnActivityIntent)
                }
                finish()
              /*  else {
              editor.putString(getString(R.string.checkBox), "False")
                    editor.commit()
                    editor.putString(getString(R.string.name), "")
                    editor.commit()
                    editor.putString(getString(R.string.password), "")
                    editor.commit()
                    Toast.makeText(this, "Please provide full details", Toast.LENGTH_LONG).show()
                    val learnActivityIntent = Intent(this, LearnActivity::class.java)
                    startActivity(learnActivityIntent)
                }*/
            }
        })
        val imghome = findViewById<ImageView>(R.id.homesign)
        imghome.setOnClickListener(View.OnClickListener {
            val homeActivityIntent = Intent(this, HomeActivity :: class.java)
            startActivity(homeActivityIntent)
        })
    }

    private fun isFormat() : Boolean{
       if (!name.text.toString().equals("")){
           if(!password.text.toString().equals("")){
                   return true
           }
           else{
               Toast.makeText(this, "Please Enter Your Password",Toast.LENGTH_LONG).show()
               return false
           }
       }
        else{
         Toast.makeText(this, "Please Enter Your Name",Toast.LENGTH_LONG).show()
           return false
       }
    }

    private fun checkSharedPreference() {
        strCheckBox = sharedPreference.getString(getString(R.string.checkBox), "False").toString()
        strName = sharedPreference.getString(getString(R.string.name), "").toString()
        strPassword = sharedPreference.getString(getString(R.string.password), "").toString()
        name.setText(strName)
        password.setText(strPassword)
        checkBox.isChecked = strCheckBox == "True"
    }
}
package com.example.quizmania

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val startbutton = findViewById<Button>(R.id.button)
        val aboutbutton = findViewById<Button>(R.id.button2)
        val nametext = findViewById<EditText>(R.id.editName)
        startbutton!!.setOnClickListener {
            val name = nametext!!.text.toString()
            val intent = Intent(applicationContext, QuestionsActivity::class.java)
            intent.putExtra("myname", name)
            startActivity(intent)
        }
     
        }
    }

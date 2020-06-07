package com.example.quizmania

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class QuestionsActivity : AppCompatActivity() {
    var tv: TextView? = null
    var submitbutton: Button? = null
    var quitbutton: Button? = null
    var radio_g: RadioGroup? = null
    var rb1: RadioButton? = null
    var rb2: RadioButton? = null
    var rb3: RadioButton? = null
    var rb4: RadioButton? = null
    var questions = arrayOf(
        "Which method can be defined only once in a program?",
        "Which of these is not a bitwise operator?",
        "Which keyword is used by method to refer to the object that invoked it?",
        "Which of these keywords is used to define interfaces in Java?",
        "Which of these access specifiers can be used for an interface?",
        "Which of the following is correct way of importing an entire package ‘pkg’?",
        "What is the return type of Constructors?",
        "Which of the following package stores all the standard java classes?",
        "Which of these method of class String is used to compare two String objects for their equality?",
        "An expression involving byte, int, & literal numbers is promoted to which of these?"
    )
    var answers = arrayOf("main method", "<=", "this", "interface", "public", "import pkg.*", "None of the mentioned", "java", "equals()", "int")
    var opt = arrayOf(
        "finalize method", "main method", "static method", "private method",
        "&", "&=", "|=", "<=",
        "import", "this", "catch", "abstract",
        "Interface", "interface", "intf", "Intf",
        "public", "protected", "private", "All of the mentioned",
        "Import pkg.", "import pkg.*", "Import pkg.*", "import pkg.",
        "int", "float", "void", "None of the mentioned",
        "lang", "java", "util", "java.packages",
        "equals()", "Equals()", "isequal()", "Isequal()",
        "int", "long", "byte", "float"
    )
    var flag = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)
        val score = findViewById<TextView>(R.id.textView4)
        val textView = findViewById<TextView>(R.id.DispName)
        val intent = intent
        val name = intent.getStringExtra("myname")
        if (name.trim { it <= ' ' } == "") textView!!.text = "Hello User" else textView!!.text = "Hello $name"
        submitbutton = findViewById<Button>(R.id.button3)
        quitbutton = findViewById<Button>(R.id.buttonquit)
        tv = findViewById<TextView>(R.id.tvque)
        radio_g = findViewById<RadioGroup>(R.id.answersgrp)
        rb1 = findViewById<RadioButton>(R.id.radioButton)
        rb2 = findViewById<RadioButton>(R.id.radioButton2)
        rb3 = findViewById<RadioButton>(R.id.radioButton3)
        rb4 = findViewById<RadioButton>(R.id.radioButton4)
        tv!!.text = questions[flag]
        rb1!!.text = opt[0]
        rb2!!.text = opt[1]
        rb3!!.text = opt[2]
        rb4!!.text = opt[3]
        submitbutton!!.setOnClickListener(View.OnClickListener { //int color = mBackgroundColor.getColor();
            //mLayout.setBackgroundColor(color);
            if (radio_g!!.checkedRadioButtonId == -1) {
                Toast.makeText(applicationContext, "Please select one choice", Toast.LENGTH_SHORT).show()
                return@OnClickListener
            }
            val uans = findViewById<RadioButton>(radio_g!!.checkedRadioButtonId)
            val ansText = uans!!.text.toString()
            //                Toast.makeText(getApplicationContext(), ansText, Toast.LENGTH_SHORT).show();
            if (ansText == answers[flag]) {
                correct++
                Toast.makeText(applicationContext, "Correct", Toast.LENGTH_SHORT).show()
            } else {
                wrong++
                Toast.makeText(applicationContext, "Wrong", Toast.LENGTH_SHORT).show()
            }
            flag++
            if (score != null) score.text = "" + correct
            if (flag < questions.size) {
                tv!!.text = questions[flag]
                rb1!!.text = opt[flag * 4]
                rb2!!.text = opt[flag * 4 + 1]
                rb3!!.text = opt[flag * 4 + 2]
                rb4!!.text = opt[flag * 4 + 3]
            } else {
                marks = correct
                val `in` = Intent(applicationContext, ResultActivity::class.java)
                startActivity(`in`)
            }
            radio_g!!.clearCheck()
        })
        quitbutton!!.setOnClickListener {
            val intent = Intent(applicationContext, ResultActivity::class.java)
            startActivity(intent)
        }
    }

    companion object {
        var marks = 0
        var correct = 0
        var wrong = 0
    }
}
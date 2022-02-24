package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    var txtUserName: TextView? = null
    var txtScore: TextView? = null
    var btnFinish: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        txtUserName = findViewById(R.id.txtUserName)
        txtScore = findViewById(R.id.txtScore)
        btnFinish = findViewById(R.id.btnFinish)


        val username = intent.getStringExtra(Constants.USER_NAME)
        txtUserName?.text = username
        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        val correctAnswer = intent.getIntExtra(Constants.CORRECT_ANSWERS,0)
        txtScore?.text = "Your score is $correctAnswer out of $totalQuestions"

        btnFinish?.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

    }
}
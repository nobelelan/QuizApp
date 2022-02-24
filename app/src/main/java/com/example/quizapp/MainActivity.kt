package com.example.quizapp

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var edtTxtName: EditText? = null

    fun btnStart(view: View){
        if (edtTxtName?.text.toString().isEmpty()){
            Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
        }else {
            val intent = Intent(this, QuizQuestionActivity::class.java)
            intent.putExtra(Constants.USER_NAME, edtTxtName?.text.toString())
            startActivity(intent)
            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        edtTxtName = findViewById(R.id.edtTxtName)
    }
}
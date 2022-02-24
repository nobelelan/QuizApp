package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {

    var progressBar: ProgressBar? = null
    var imgContext: ImageView? = null
    var btnSubmit: Button? = null
    var txtCounter: TextView? = null
    var txtQuestion: TextView? = null
    var txtOne: TextView? = null
    var txtTwo: TextView? = null
    var txtThree: TextView? = null
    var txtFour: TextView? = null

    private  var mCurrentPosition: Int = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int =0
    private var mCorrectAnswers: Int = 0
    private var mUserName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        mUserName = intent.getStringExtra(Constants.USER_NAME)

        progressBar = findViewById(R.id.progressBar)
        imgContext = findViewById(R.id.imgContext)
        btnSubmit = findViewById(R.id.btnSubmit)
        txtCounter = findViewById(R.id.txtCounter)
        txtQuestion = findViewById(R.id.txtQuestion)
        txtOne = findViewById(R.id.txtOne)
        txtTwo = findViewById(R.id.txtTwo)
        txtThree = findViewById(R.id.txtThree)
        txtFour = findViewById(R.id.txtFour)

        mQuestionsList = Constants.getQuestions()

        setQuestion()

        txtOne?.setOnClickListener(this)
        txtTwo?.setOnClickListener(this)
        txtThree?.setOnClickListener(this)
        txtFour?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)

    }

    private fun setQuestion(){
        val question= mQuestionsList!![mCurrentPosition-1]

        defaultOptionsView()

        if (mCurrentPosition == mQuestionsList!!.size){
            btnSubmit?.text = "FINISH"
        }else{
            btnSubmit?.text = "SUBMIT"
        }

        progressBar?.progress = mCurrentPosition
        txtCounter?.text = "$mCurrentPosition"+"/"+progressBar?.max

        txtQuestion?.text = question!!.question
        imgContext?.setImageResource(question.image)
        txtOne?.text = question.optionOne
        txtTwo?.text = question.optionTwo
        txtThree?.text = question.optionThree
        txtFour?.text = question.optionFour
    }

    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        options.add(0, txtOne!!)
        options.add(1, txtTwo!!)
        options.add(2, txtThree!!)
        options.add(3, txtFour!!)

        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
        }

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.txtOne ->{
                selectedOptionView(txtOne!!, 1)
            }

            R.id.txtTwo ->{
                selectedOptionView(txtTwo!!, 2)
            }

            R.id.txtThree ->{
                selectedOptionView(txtThree!!, 3)
            }

            R.id.txtFour ->{
                selectedOptionView(txtFour!!, 4)
            }

            R.id.btnSubmit ->{
                if (mSelectedOptionPosition == 0){
                    mCurrentPosition++

                    when{
                        mCurrentPosition <= mQuestionsList!!.size ->{
                            setQuestion()
                        }else->{
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME,mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList!!.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                }else{
                    val question = mQuestionsList?.get(mCurrentPosition -1)
                    if (question!!.correctAnswer != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    }else{
                        mCorrectAnswers++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if (mCurrentPosition == mQuestionsList!!.size){
                        btnSubmit?.text = "FINISH"
                    }else{
                        btnSubmit?.text = "NEXT"
                    }

                    mSelectedOptionPosition = 0
                }
            }
        }
    }
    private fun answerView(answer: Int,drawableView: Int){

        when(answer){
            1 ->{
                txtOne?.background = ContextCompat.getDrawable(this, drawableView)
            }
            2 ->{
                txtTwo?.background = ContextCompat.getDrawable(this, drawableView)
            }
            3 ->{
                txtThree?.background = ContextCompat.getDrawable(this, drawableView)
            }
            4 ->{
                txtFour?.background = ContextCompat.getDrawable(this, drawableView)
            }

        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int){
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)
    }


}
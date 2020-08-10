package com.example.first_android

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_board.*

class BoardActivity : AppCompatActivity() {
    private val activityName = "BOARD_ACTIVITY"

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_board)

        val playerOne = intent.getStringExtra("FISRT_NAME")
        val playerTwo = intent.getStringExtra("LAST_NAME")
        textView3.text = "$playerOne VS $playerTwo"

    }

    override fun onStart() {
        super.onStart()
        println("$activityName ON_START")
    }

    override fun onResume() {
        super.onResume()
        println("$activityName ON_RESUME")
    }

    override fun onPause() {
        super.onPause()
        println("$activityName ON_PAUSE")
    }

    override fun onStop() {
        super.onStop()
        println("$activityName ON_STOP")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("$activityName ON_DESTROY")
    }
}
package com.example.first_android

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_board.*

class BoardActivity : AppCompatActivity() {
    private val activityName = "PLAY_GAME_ACTIVITY"

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_board)
        val playerOne = intent.getStringExtra("FIRST_NAME")
        textView3.text = "$playerOne's Turn"
    }

    fun buttonClick(view: View) {
        val buttonSelected = view as Button
        playGame(buttonSelected)
    }

    private var activePlayer = 1

    @SuppressLint("SetTextI18n")
    private fun playGame(buttonSelected: Button) {
        val playerOne = intent.getStringExtra("FIRST_NAME")
        val playerTwo = intent.getStringExtra("LAST_NAME")
        if(activePlayer==1){
            textView3.text = "$playerTwo's Turn"
            buttonSelected.text = "X"
            activePlayer = 2
        }else{
            textView3.text = "$playerOne's Turn"
            buttonSelected.text = "O"
            activePlayer = 1
        }
        //disable button, after click
        buttonSelected.isEnabled = false;
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
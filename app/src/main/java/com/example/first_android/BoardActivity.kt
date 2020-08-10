package com.example.first_android

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.first_android.constant.FIRST_NAME
import com.example.first_android.constant.LAST_NAME
import kotlinx.android.synthetic.main.activity_board.*

class BoardActivity : AppCompatActivity() {
    private val activityName = "PLAY_GAME_ACTIVITY"

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_board)
        val playerOne = intent.getStringExtra(FIRST_NAME)
        textView3.text = "$playerOne's Turn"
    }

    fun buttonClick(view: View) {
        val buttonSelected = view as Button
        var value = 0
        //when case button 1..9
        when(buttonSelected.id) {
            R.id.button1 -> value = 1
            R.id.button2 -> value = 2
            R.id.button3 -> value = 3
            R.id.button4 -> value = 4
            R.id.button5 -> value = 5
            R.id.button6 -> value = 6
            R.id.button7 -> value = 7
            R.id.button8 -> value = 8
            R.id.button9 -> value = 9
        }
        playGame(value,buttonSelected)
    }

    private var player1 = ArrayList<Int>()
    private var player2 = ArrayList<Int>()

    private var activePlayer = 1

    @SuppressLint("SetTextI18n")
    private fun playGame(value: Int, buttonSelected: Button) {
        val playerOne = intent.getStringExtra(FIRST_NAME)
        val playerTwo = intent.getStringExtra(LAST_NAME)
        if(activePlayer==1){
            textView3.text = "$playerTwo's Turn"
            buttonSelected.text = "X"
            player1.add(value)
            activePlayer = 2
        } else{
            textView3.text = "$playerOne's Turn"
            buttonSelected.text = "O"
            player2.add(value)
            activePlayer = 1
        }
        //disable button, after click
        buttonSelected.isEnabled = false;
        //check winner
        getWinner()
    }

    private fun getWinner() {
        val playerOne = intent.getStringExtra(FIRST_NAME)
        val playerTwo = intent.getStringExtra(LAST_NAME)
        var winner = -1
        if(player1.contains(1) && player1.contains(2) && player1.contains(3)){
            winner=1
        }
        if(player2.contains(1) && player2.contains(2) && player2.contains(3)){
            winner=2
        }


        // row 2
        if(player1.contains(4) && player1.contains(5) && player1.contains(6)){
            winner=1
        }
        if(player2.contains(4) && player2.contains(5) && player2.contains(6)){
            winner=2
        }




        // row 3
        if(player1.contains(7) && player1.contains(8) && player1.contains(9)){
            winner=1
        }
        if(player2.contains(7) && player2.contains(8) && player2.contains(9)){
            winner=2
        }



        // col 1
        if(player1.contains(1) && player1.contains(4) && player1.contains(7)){
            winner=1
        }
        if(player2.contains(1) && player2.contains(4) && player2.contains(7)){
            winner=2
        }



        // col 2
        if(player1.contains(2) && player1.contains(5) && player1.contains(8)){
            winner=1
        }
        if(player2.contains(2) && player2.contains(5) && player2.contains(8)){
            winner=2
        }


        // col 3
        if(player1.contains(3) && player1.contains(6) && player1.contains(9)){
            winner=1
        }
        if(player2.contains(3) && player2.contains(6) && player2.contains(9)){
            winner=2
        }

        //diagonal
        if(player1.contains(1) && player1.contains(5) && player1.contains(9)){
            winner=1
        }
        if(player2.contains(1) && player2.contains(5) && player2.contains(9)){
            winner=2
        }

        if(player1.contains(3) && player1.contains(5) && player1.contains(7)){
            winner=1
        }
        if(player2.contains(3) && player2.contains(5) && player2.contains(7)){
            winner=2
        }

        if( winner != -1){

            if (winner==1){
                Toast.makeText(this," $playerOne  win the game", Toast.LENGTH_LONG).show()
                finish()
            }else{
                Toast.makeText(this," $playerTwo win the game", Toast.LENGTH_LONG).show()
                finish()

            }

        }
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
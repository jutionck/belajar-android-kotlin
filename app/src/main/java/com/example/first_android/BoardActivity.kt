package com.example.first_android

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.databinding.DataBindingUtil
import com.example.first_android.constant.FIRST_NAME
import com.example.first_android.constant.LAST_NAME
import kotlinx.android.synthetic.main.activity_board.*

class BoardActivity : AppCompatActivity() {
    private val activityName = "PLAY_GAME_ACTIVITY"
    private lateinit var player1: Player
    private lateinit var player2: Player
    private lateinit var currentPlayer: Player

    private val boardGame = arrayOf("","","","","","","","","")


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_board)
        val binding: ActivityBoardBinding = DataBindingUtil.setContentView(this, R.layout.activity_board)
        val playerOne = intent.getStringExtra(FIRST_NAME)
        val playerTwo = intent.getStringExtra(LAST_NAME)

        player1 = Player(playerOne, "X")
        player2 = Player(playerTwo, "0")

        binding.player1 = player1
        binding.player2 = player2
        currentPlayer = player1
        setTurn()
    }


    fun flip(view: View) {
        view as Button
        val index = view.tag.toString().toInt()
        if(boardGame[index] == "") {
            boardGame[view.tag.toString().toInt()] = currentPlayer.mark
        }
        view.text = currentPlayer.mark
        setTurn()
    }

    @SuppressLint("SetTextI18n")
    fun setTurn() {
        if(currentPlayer==player1) {
            currentPlayer = player2
        } else  {
            currentPlayer = player1
        }
        textView3.text = "${currentPlayer.name}'s turn"
    }
}
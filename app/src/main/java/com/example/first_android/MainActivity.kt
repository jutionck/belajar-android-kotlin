package com.example.first_android

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.example.first_android.constant.FIRST_NAME
import com.example.first_android.constant.LAST_NAME
import com.example.first_android.view_model.PlayerViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private val activityName = "MAIN_ACTIVITY"
    private val playerViewModel by viewModels<PlayerViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button_tekan.setOnClickListener(this)
        button_pencet.setOnClickListener(this)
        setResultText()
    }

    @SuppressLint("SetTextI18n")
    private fun setResultText() {
        viewPlayer.text = "${playerViewModel.player1Name} VC ${playerViewModel.player2Name}"
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(v: View?) {
        when(v) {
            button_tekan -> toBoardActivity()
            button_pencet -> { showName() }
        }
    }

    private fun toBoardActivity() {
        val intent = Intent(this, BoardActivity::class.java)
        intent.putExtra(FIRST_NAME, input_name.text.toString())
        intent.putExtra(LAST_NAME, input_name2.text.toString())
        startActivity(intent)
    }

    fun showName() {
        playerViewModel.player1Name = input_name.text.toString()
        playerViewModel.player2Name = input_name2.text.toString()
        setResultText()
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
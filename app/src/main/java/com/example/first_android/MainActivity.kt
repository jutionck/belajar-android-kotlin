package com.example.first_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private val activityName = "MAIN_ACTIVITY"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button_tekan.setOnClickListener(this)
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




    override fun onClick(v: View?) {
        when(v) {
            button_tekan -> toBoardActivity()
        }
    }

    private fun toBoardActivity() {
        val intent = Intent(this, BoardActivity::class.java)
        intent.putExtra("FIRST_NAME", input_name.text.toString())
        intent.putExtra("LAST_NAME", input_name2.text.toString())
        startActivity(intent)
    }

}
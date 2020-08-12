package com.example.first_android

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_counter.*
import kotlinx.android.synthetic.main.fragment_counter_show.*

class MainActivity : AppCompatActivity() {

    private var id = 0;

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val counterFragment = CounterFragment()
        val counterShowFragment = CounterShowFragment()

        counterShowFragment.counterValue.text = "" + id

        counterFragment.increaseButton.setOnClickListener{
            counterShowFragment.counterValue.text = "" + id++
        }

        counterFragment.decreaseButton.setOnClickListener{
            counterShowFragment.counterValue.text = "" + id--
        }
    }


}
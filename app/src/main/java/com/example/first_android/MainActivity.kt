package com.example.first_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var id = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val counterFragment = CounterFragment()
//        val counterShowFragment = CounterShowFragment()
//
//        R.id.counterValue
//
//        supportFragmentManager.beginTransaction().apply {
//            replace(R.id.increaseButton, counterFragment)
//            commit()
//        }
    }


}
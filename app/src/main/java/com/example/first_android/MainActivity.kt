package com.example.first_android

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_counter_show.*

class MainActivity : AppCompatActivity() {

    //inisialisasi nanti
    private lateinit var counterFragment: CounterFragment
    private lateinit var counterShowFragment: CounterShowFragment
    private var counter = 0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        counterFragment = fragment1 as CounterFragment
        counterShowFragment = fragment2 as CounterShowFragment

    }

    fun notifyIncrease() {
        counter+=1
        println("Counter $counter")
        counterShowFragment.notifyShowCounter(counter)
    }

    fun notifyDecrease() {
        counter-=1
        println("Counter $counter")
        counterShowFragment.notifyShowCounter(counter)
    }
}
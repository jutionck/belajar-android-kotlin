package com.example.first_android

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import kotlinx.android.synthetic.main.fragment_counter_show.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CounterFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CounterFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val v = inflater.inflate(R.layout.fragment_counter, container, false)
        var id = 0;

        val btnIncrease = v.findViewById<View>(R.id.increaseButton) as Button
        val btnDecrease = v.findViewById<View>(R.id.decreaseButton) as Button

        btnIncrease.setOnClickListener {
            val fragment = CounterShowFragment()
            val fragmentManager = activity!!.supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.counterValue, fragment)
            fragmentTransaction.addToBackStack(null)
            counterValue.text = "" + id++
            fragmentTransaction.commit()
        }

        btnDecrease.setOnClickListener {
            val fragment = CounterShowFragment()
            val fragmentManager = activity!!.supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.counterValue, fragment)
            fragmentTransaction.addToBackStack(null)
            counterValue.text = "" + id--
            fragmentTransaction.commit()
        }
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_counter, container, false)
    }
}
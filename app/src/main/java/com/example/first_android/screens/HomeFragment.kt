package com.example.first_android.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.first_android.R
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_login.*

class HomeFragment : Fragment(), View.OnClickListener {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        btnTransfer.setOnClickListener(this)
        btnHistory.setOnClickListener(this)
        btnCallOffice.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v) {
            btnTransfer -> {navController.navigate(R.id.action_homeFragment_to_transferFragment)}
            btnHistory -> {navController.navigate(R.id.action_homeFragment_to_historyFragment)}
            btnCallOffice -> {

            }
        }
    }
}
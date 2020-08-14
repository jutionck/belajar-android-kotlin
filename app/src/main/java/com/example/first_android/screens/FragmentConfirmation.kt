package com.example.first_android.screens

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.first_android.R
import com.example.first_android.view_model.ViewModelNavigation
import kotlinx.android.synthetic.main.fragment_confirmation.*
import kotlinx.android.synthetic.main.fragment_input_amount.*
import kotlinx.android.synthetic.main.fragment_input_recipient.*

class FragmentConfirmation : Fragment() {

    private val viewModelNavigation: ViewModelNavigation by activityViewModels<ViewModelNavigation>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_confirmation, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModelNavigation.username.observe(viewLifecycleOwner, Observer { getUserNameReceiver(it) })
        viewModelNavigation.accountNumber.observe(viewLifecycleOwner, Observer { getAccountNumber(it) })
        viewModelNavigation.amountTransfer.observe(viewLifecycleOwner, Observer { getAmountTransfer(it) })
        viewModelNavigation.nameBank.observe(viewLifecycleOwner, Observer { getBankName(it) })
    }

    @SuppressLint("SetTextI18n")
    private fun getUserNameReceiver(it: String?) {
        nameConfirmation.text = "Sent to $it"
    }

    private fun getAccountNumber(it: String?) {
        accountNumberConfirmation.text = it
    }

    @SuppressLint("SetTextI18n")
    private fun getAmountTransfer(it: Int?) {
        amountConfirmation.text = "Rp. $it"
    }

    private fun getBankName(it: String?) {
        bankNameConfirmation.text = it
    }

}
package com.example.first_android.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.first_android.R
import com.example.first_android.transaksi.Transaksi
import com.example.first_android.transaksi.TransaksiViewModel
import kotlinx.android.synthetic.main.fragment_amount.*
import kotlinx.android.synthetic.main.fragment_transfer.*

class AmountFragment : Fragment(), View.OnClickListener {

    private val transaksiViewModel by activityViewModels<TransaksiViewModel>()

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_amount, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        button_send.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v) {
            button_send -> {
                val bankName = arguments?.getString("bankName")
                val newFilm = Transaksi(user_owner_id = "1", trans_date = "2020-08-24 17:00", destination = bankName.toString(), amount = amountTextInput.toString(), description = keteranganTextInput.toString())
                transaksiViewModel.createTransaksi(newFilm)
                navController.navigate(R.id.action_amountFragment_to_confirmFragment)
            }

        }
    }

}
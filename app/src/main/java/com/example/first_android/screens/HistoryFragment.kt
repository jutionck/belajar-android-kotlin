package com.example.first_android.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.first_android.R
import com.example.first_android.transaksi.TransaksiRecycleAdapter
import com.example.first_android.transaksi.TransaksiViewModel
import kotlinx.android.synthetic.main.fragment_history.*
import kotlinx.android.synthetic.main.history_list_item.*

class HistoryFragment : Fragment() {

    private val transaksiViewModel by activityViewModels<TransaksiViewModel>()
    private lateinit var transaksiRecycleAdapter: TransaksiRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        historyRecycleView.layoutManager = LinearLayoutManager(activity)
//        transaksiViewModel.getTranaksiByID("1")
        transaksiViewModel.transaksiList.observe(viewLifecycleOwner, Observer {
            transaksiRecycleAdapter = TransaksiRecycleAdapter(it)
            historyRecycleView.adapter = transaksiRecycleAdapter
        })
        transaksiViewModel.getAllTransaksi()
    }
}
package com.example.first_android.transaksi

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.first_android.config.RetrofitBuilder

class TransaksiViewModel : ViewModel() {


    private val transaksiRepository: TransaksiRepository

    init {
        val transaksiAPI = RetrofitBuilder.createRetrofit().create(TransaksiAPI::class.java)
        transaksiRepository = TransaksiRepository(transaksiAPI)
    }

    val transaksi: LiveData<Transaksi> = transaksiRepository.transaksi
    val transaksiList: LiveData<List<Transaksi>> = transaksiRepository.transaksiList

    fun getAllTransaksi() {
        transaksiRepository.getAllTransaksi()
    }

    fun getTranaksiByID(user_owner_id: String) {
        transaksiRepository.getTransaksiByID(user_owner_id)
    }

    fun createTransaksi(transaksi: Transaksi) {
        transaksiRepository.saveTransaksi(transaksi)
    }

}
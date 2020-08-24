package com.example.first_android.transaksi

import androidx.lifecycle.MutableLiveData
import com.example.first_android.respon_data.ResponseData
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TransaksiRepository (private val transaksiAPI: TransaksiAPI) {

    var transaksi: MutableLiveData<Transaksi> = MutableLiveData<Transaksi>()
    val transaksiList: MutableLiveData<List<Transaksi>> = MutableLiveData<List<Transaksi>>()

    fun getAllTransaksi(){

        //enqueue like a coroutine, make new request
        transaksiAPI.getAllTransaksi().enqueue(object : Callback<ResponseData> {

            override fun onFailure(call: Call<ResponseData>, t: Throwable) {
                println(t.localizedMessage)
            }

            override fun onResponse(call: Call<ResponseData>, response: Response<ResponseData>) {
                val responses = response.body()

                if (responses?.status == "200"){
                    val res = responses.result
                    val gson = Gson()
                    transaksiList.value = gson.fromJson(gson.toJson(res), Array<Transaksi>::class.java).toList()

                }
            }
        })
    }

    fun getTransaksiByID(trans_id: String){
        transaksiAPI.getTransaksiByID(trans_id).enqueue(object : Callback<ResponseData> {
            override fun onFailure(call: Call<ResponseData>, t: Throwable) {
                println(t.localizedMessage)
            }

            override fun onResponse(call: Call<ResponseData>, response: Response<ResponseData>) {
                val responseData = response.body()
                println("ID $responseData")

                if (responseData?.status == "200") {
                    val res = responseData.result
                    val gson = Gson()
                    transaksiList.value = gson.fromJson(gson.toJson(res), Array<Transaksi>::class.java).toList()
                } else {
                    transaksi.value = Transaksi("", "1", "", "", "", "")
                    println("[ERROR] Data not found")
                }
            }
        })
    }

    fun saveTransaksi(transaksi: Transaksi) {
        transaksiAPI.createTransaksi(transaksi).enqueue(object : Callback<ResponseData> {
            override fun onResponse(call: Call<ResponseData>, response: Response<ResponseData>) {
                val responseData = response.body()

                if (responseData?.status == "OK") {
                    println("OK")
                }
            }

            override fun onFailure(call: Call<ResponseData>, t: Throwable) {
                t.printStackTrace()
            }

        })
    }

}
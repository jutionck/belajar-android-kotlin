package com.example.first_android.transaksi

import com.example.first_android.respon_data.ResponseData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface TransaksiAPI {

    @GET("transaksi")
    fun getAllTransaksi(): Call<ResponseData>

    @GET("transaksi/user/{user_owner_id}")
    fun getTransaksiByID(@Path("user_owner_id") id: String): Call<ResponseData>

    @POST("transaksi")
    fun createTransaksi(@Body transaksi: Transaksi): Call<ResponseData>
}
package com.example.first_android.user

import com.example.first_android.respon_data.ResponseData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface UserAPI {

    @GET("user/{userID}")
    fun getUserByID(@Path("userID") id: String): Call<User>

    @POST("user")
    fun createUser(@Body user: User): Call<ResponseData>
}

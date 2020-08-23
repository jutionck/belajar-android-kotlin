package com.example.first_android.food

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface FoodAPI {

    @GET("food/{foodCode}")
    fun getFoodByID(@Path("foodCode") foodCode: String): Call<Food>


}
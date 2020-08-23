package com.example.first_android.food

import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.sql.Wrapper

class FoodRepository(private val foodAPI: FoodAPI){
    var food: MutableLiveData<Food> = MutableLiveData<Food>()

    fun getFood(foodCode: String){
        //enqueue seperti coroutine, membuat request baru di antrian request
        foodAPI.getFoodByID(foodCode).enqueue(object : Callback<Food> {

            override fun onFailure(call: Call<Food>, t: Throwable) {
                println(t.localizedMessage)
            }

            override fun onResponse(call: Call<Food>, response: Response<Food>) {
                food.value = response.body()
                //jika pakai respon
//                if(response.code()==200) {
//                    val response = response.body()
//                    val gson = Gson()
//                    val stringResult = gson.toJson(response?.result)
//                    val nanna = gson.fromJson<Food>(stringResult, Food::class.java)
//                    food.value = nanna
//                }
            }
        })
    }
}


package com.example.first_android.user

import androidx.lifecycle.MutableLiveData
import com.example.first_android.respon_data.ResponseData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.sql.Wrapper

class UserRepository(private val userAPI: UserAPI) {

    var user: MutableLiveData<User> = MutableLiveData<User>()

    fun getUser(userID: String){
        //enqueue seperti coroutine, membuat request baru di antrian request
        userAPI.getUserByID(userID).enqueue(object : Callback<User> {

            override fun onFailure(call: Call<User>, t: Throwable) {
                println(t.localizedMessage)
            }

            override fun onResponse(call: Call<User>, response: Response<User>) {
                user.value = response.body()
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

    fun saveUser(user: User) {
        userAPI.createUser(user).enqueue(object : Callback<ResponseData> {
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
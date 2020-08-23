package com.example.first_android.film

import androidx.lifecycle.MutableLiveData
import com.example.first_android.respon_data.ResponseData
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FilmRepository(private val filmAPI: FilmAPI) {

    var film: MutableLiveData<Film> = MutableLiveData<Film>()

    fun getAllFilm(){

        //enqueue like a coroutine, make new request
        filmAPI.getAllFilm().enqueue(object : Callback<ResponseData> {

            override fun onFailure(call: Call<ResponseData>, t: Throwable) {
                println(t.localizedMessage)
            }

            override fun onResponse(call: Call<ResponseData>, response: Response<ResponseData>) {
                film.value = response.body()

                //if use response in your API
                if(response.code()==200) {
                    val responses = response.body()
                    val gson = Gson()
                    val stringResult = gson.toJson(responses?.)
                    val nanna = gson.fromJson<Film>(stringResult, Film::class.java::class.java)
                    film.value = nanna
                }
            }
        })
    }

    fun getFilmByID(userID: String){
        filmAPI.getFilmByID(userID).enqueue(object : Callback<Film> {

            override fun onFailure(call: Call<Film>, t: Throwable) {
                println(t.localizedMessage)
            }

            override fun onResponse(call: Call<Film>, response: Response<Film>) {
                film.value = response.body()
            }
        })
    }

    fun saveFilm(film: Film) {
        filmAPI.createFilm(film).enqueue(object : Callback<ResponseData> {
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
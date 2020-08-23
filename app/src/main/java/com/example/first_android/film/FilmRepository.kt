package com.example.first_android.film

import androidx.lifecycle.MutableLiveData
import com.example.first_android.respon_data.ResponseData
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FilmRepository(private val filmAPI: FilmAPI) {

    var film: MutableLiveData<Film> = MutableLiveData<Film>()
    var filmList: MutableLiveData<List<Film>> = MutableLiveData<List<Film>>()

    fun getAllFilm(){

        //enqueue like a coroutine, make new request
        filmAPI.getAllFilm().enqueue(object : Callback<List<Film>> {

            override fun onFailure(call: Call<List<Film>>, t: Throwable) {
                println(t.localizedMessage)
            }

            override fun onResponse(call: Call<List<Film>>, response: Response<List<Film>>) {
                val responses = response.body()
                val gson = Gson()
                val stringResponse = gson.toJson(responses)
                val movieObject:List<Film> = gson.fromJson(stringResponse,Array<Film>::class.java).toList()
                filmList.value = movieObject
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
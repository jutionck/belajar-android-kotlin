package com.example.first_android.artist

import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ArtistRepository(private val artistAPI: ArtistAPI){
    var artist: MutableLiveData<Artist> = MutableLiveData<Artist>()

    fun getArtist(id: String){
        artistAPI.getArtistByID(id).enqueue(object : Callback<Artist>{

            override fun onFailure(call: Call<Artist>, t: Throwable) {
                println(t.localizedMessage)
            }

            override fun onResponse(call: Call<Artist>, response: Response<Artist>) {
                artist.value = response.body()
            }
        })
    }
}
package com.example.first_android.artist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.first_android.config.RetrofitBuilder

class ArtistViewModel : ViewModel() {

    val artistRepository: ArtistRepository

    init {
        val artistApi = RetrofitBuilder.createRetrofit().create(ArtistAPI::class.java)
        artistRepository = ArtistRepository(artistApi)
    }

    val artist: LiveData<Artist> = artistRepository.artist

    fun getArtist(id: String) {
        artistRepository.getArtist(id)
    }
}
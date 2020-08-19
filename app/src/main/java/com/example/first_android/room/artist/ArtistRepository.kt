package com.example.first_android.room.artist

import androidx.lifecycle.LiveData


//layer Repository bertujuan untuk asal mula pengambilan data dari mana
//dari Dao atau Network
class ArtistRepository(private val artistDao: ArtistDao) {

    val allArtist: LiveData<List<Artist>> = artistDao.getAllArtist()

    fun createArtist(artist: Artist) {
        artistDao.createArtist(artist)
    }
}
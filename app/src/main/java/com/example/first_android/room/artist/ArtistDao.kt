package com.example.first_android.room.artist

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.first_android.room.artist.Artist

@Dao
interface ArtistDao {

    @Insert
    fun createArtist(artist: Artist)

    @Query(value = "SELECT * FROM Artist")
    fun getAllArtist(): LiveData<List<Artist>>

    @Query(value = "SELECT * FROM Artist WHERE id = :id")
    fun getArtistById(id:Int): Artist
}
package com.example.first_android.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.first_android.room.AppRoomDatabase
import com.example.first_android.room.artist.Artist
import com.example.first_android.room.artist.ArtistRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: ArtistRepository
    val allArtist: LiveData<List<Artist>>

    init {
        val artistDao = AppRoomDatabase.getDatabaseInstance(application).artistDao()
        repository = ArtistRepository(artistDao)
        allArtist = repository.allArtist
    }

    //menggunakan coroutine
    //karena baik ke db maupun network itu membutuhkan waktu yang lebih ekstra
    fun createNewArtist(artist: Artist) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.createArtist(artist)
        }
    }

}
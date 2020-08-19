package com.example.first_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.first_android.room.artist.Artist
import com.example.first_android.viewmodel.ArtistViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val artistViewModel by viewModels<ArtistViewModel>()
    private lateinit var artistRecycleViewAdapter: ArtistRecycleViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        artistRecycleView.layoutManager = LinearLayoutManager(this)

        artistViewModel.allArtist.observe(this, Observer {
            artistRecycleViewAdapter = ArtistRecycleViewAdapter(it)
            artistRecycleView.adapter = artistRecycleViewAdapter
        })
    }

    fun addNewArtist(view: View) {
        val name = artistNameInputText.text.toString()
        val debut = debutInputText.text.toString()
        artistViewModel.createNewArtist(Artist(name = name, debut = debut, originPlace = ""))
    }
}



package com.example.first_android.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.first_android.R
import com.example.first_android.SongRecycleAdapter
import com.example.first_android.view_model.AlbumViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.album_item_layout.*
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.fragment_home.*

class FragmentDetail : Fragment(), View.OnClickListener {

    private val albumViewModel by activityViewModels<AlbumViewModel>()
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val albumId = arguments?.getInt("albumId") ?: 1

        albumViewModel.getAlbumWithId(albumId).observe(viewLifecycleOwner, Observer {
            song_title_detail.text = it.artistName
            bandName.text = it.albumTitle
            Picasso.with(activity).load(it.albumImage).into(imageSongDetail)
        })

        listSong_recycle_view.layoutManager = LinearLayoutManager(activity)
        albumViewModel.getSongWithAlbumId(albumId).observe(viewLifecycleOwner, Observer {
            listSong_recycle_view.adapter = SongRecycleAdapter(it)
        })

        btnAddSong.setOnClickListener(this)
        navController= Navigation.findNavController(view)
    }

    override fun onClick(v: View?) {
        when(v){

            btnAddSong -> {
                val albumId = arguments?.getInt("albumId") ?: 1
                val bundle = bundleOf(Pair("albumId", albumId))
                navController.navigate(R.id.action_fragmentDetail_to_fragmentAddSong, bundle)
            }
        }
    }

}
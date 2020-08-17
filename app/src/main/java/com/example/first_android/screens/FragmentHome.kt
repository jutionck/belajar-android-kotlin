package com.example.first_android.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.first_android.R
import com.example.first_android.SongRecycleAdapter
import com.example.first_android.view_model.SongViewModel
import kotlinx.android.synthetic.main.fragment_home.*

class FragmentHome : Fragment(), View.OnClickListener {

    private val songViewModel by activityViewModels<SongViewModel>()
    private lateinit var songRecycleAdapter: SongRecycleAdapter
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        song_recycle_view.layoutManager = LinearLayoutManager(activity)
        songRecycleAdapter = activity?.let { SongRecycleAdapter(songViewModel, it) }!!
        song_recycle_view.adapter = songRecycleAdapter

        songViewModel.songData.observe(viewLifecycleOwner,Observer{
            songRecycleAdapter.notifyDataSetChanged()
        })

        fab.setOnClickListener(this)
        navController= Navigation.findNavController(view)
    }

    override fun onClick(v: View?) {
        when(v){
            fab -> {navController.navigate(R.id.action_fragmentHome_to_fragmentAddSong)}
        }
    }
}
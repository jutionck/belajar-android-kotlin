package com.example.first_android.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.first_android.R
import com.example.first_android.view_model.SongViewModel
import kotlinx.android.synthetic.main.fragment_add_song.*

class FragmentAddSong : Fragment(), View.OnClickListener {

    private val songViewModel by activityViewModels<SongViewModel>()
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_song, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button_save.setOnClickListener(this)
        navController= Navigation.findNavController(view)
    }

    override fun onClick(v: View?) {
        when(v){
            button_save->{
                songViewModel.addSong(
                    input_artist_name.text.toString(),
                    input_song_title.text.toString(),
                    input_song_image.text.toString())
                Toast.makeText(v?.context,"SUCCESS: Add song", Toast.LENGTH_SHORT).show()
                navController.navigate(R.id.action_fragmentAddSong_pop2)
            }

        }
    }

}
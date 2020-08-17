package com.example.first_android.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.example.first_android.R
import com.example.first_android.view_model.SongViewModel
import kotlinx.android.synthetic.main.fragment_add_song.*

class FragmentAddSong : Fragment(), View.OnClickListener {

    private val songViewModel by activityViewModels<SongViewModel>()

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
        save_btn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v){
            save_btn->{
                songViewModel.addSong(
                    input_name.text.toString(),
                    input_title.text.toString(),
                    input_image.text.toString())
                Toast.makeText(v?.context,"SUCCESS: Add song", Toast.LENGTH_SHORT).show()
            }

        }
    }

}
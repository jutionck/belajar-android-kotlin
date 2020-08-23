package com.example.first_android

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.first_android.food.FoodViewModel
import com.example.first_android.user.UserViewModel
import kotlinx.android.synthetic.main.fragment_food.*

class FoodFragment : Fragment(), View.OnClickListener {

    private val userViewModel by activityViewModels<UserViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_food, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        userViewModel.user.observe(viewLifecycleOwner, Observer {
            artistNameText.text = it.username
        })
        fetchButton.setOnClickListener(this)
    }

    private fun getFoodByID() {
        userViewModel.getUser(artistInputText.text.toString())
    }

    override fun onClick(v: View?) {
        when(v) {
            fetchButton -> getFoodByID()
        }
    }
}
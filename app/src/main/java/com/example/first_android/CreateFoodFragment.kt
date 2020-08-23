package com.example.first_android

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.example.first_android.user.User
import com.example.first_android.user.UserViewModel
import kotlinx.android.synthetic.main.fragment_create_food.*

class CreateFoodFragment : Fragment() {

    private val userViewModel by activityViewModels<UserViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_food, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        submitUser.setOnClickListener {
            val newUser = User(username = usernameTextInput.text.toString(), firstName = firstNameTextInput.text.toString(), lastName = lastNameTextInput.text.toString(), password = passwordTextInput.text.toString())
            userViewModel.createUser(newUser)
            Navigation.findNavController(view).navigate(R.id.action_createFoodFragment_pop)
        }
    }
}
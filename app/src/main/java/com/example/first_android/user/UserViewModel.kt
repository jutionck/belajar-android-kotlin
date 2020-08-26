package com.example.first_android.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.first_android.config.RetrofitBuilder

class UserViewModel(private val userRepository: UserRepository) : ViewModel() {

    val user: LiveData<User> = userRepository.user

    fun getUser(userID: String) {
        userRepository.getUser(userID)
    }

    fun createUser(user: User) {
        userRepository.saveUser(user)
    }

}
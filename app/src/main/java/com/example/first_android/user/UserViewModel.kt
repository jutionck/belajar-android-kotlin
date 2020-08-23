package com.example.first_android.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.first_android.config.RetrofitBuilder

class UserViewModel : ViewModel() {


    private val userRepository: UserRepository

    init {
        val userAPI = RetrofitBuilder.createRetrofit().create(UserAPI::class.java)
        userRepository = UserRepository(userAPI)
    }

    val user: LiveData<User> = userRepository.user

    fun getUser(userID: String) {
        userRepository.getUser(userID)
    }

    fun createUser(user: User) {
        userRepository.saveUser(user)
    }

}
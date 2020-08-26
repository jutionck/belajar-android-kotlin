package com.example.first_android.container
import com.example.first_android.config.RetrofitBuilder
import com.example.first_android.user.UserAPI
import com.example.first_android.user.UserRepository
import com.example.first_android.user.UserViewModel

class AppContainer {

    private val userAPI: UserAPI = RetrofitBuilder.createRetrofit().create(UserAPI::class.java)
    private val userRepository: UserRepository = UserRepository(userAPI)
    val userViewModel: UserViewModel = UserViewModel(userRepository)
}

class UserViewModelFactory(val userRepository: UserRepository):
    Factory<UserViewModel> {
    override fun create(): UserViewModel {
        return UserViewModel(userRepository)
    }

}

interface Factory<T>{
    fun create(): T
}
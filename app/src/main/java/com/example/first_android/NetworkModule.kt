package com.example.first_android

import com.example.first_android.config.RetrofitBuilder
import com.example.first_android.user.UserAPI
import dagger.Module
import dagger.Provides

@Module
class NetworkModule {

    @Provides
    fun providerUserAPI(): UserAPI {
        return RetrofitBuilder.createRetrofit().create(UserAPI::class.java)
    }


}
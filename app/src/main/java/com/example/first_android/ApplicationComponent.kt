package com.example.first_android

import com.example.first_android.activity.MainActivity
import com.example.first_android.screen.CreateFoodFragment
import com.example.first_android.screen.FoodFragment
import dagger.Component


@Component(modules = [NetworkModule::class])
interface ApplicationComponent {

    fun inject(mainActivity: MainActivity)
    fun inject(userFragment: FoodFragment)
    fun inject(createFoodFragment: CreateFoodFragment)
}
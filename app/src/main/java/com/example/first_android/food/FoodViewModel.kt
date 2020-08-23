package com.example.first_android.food

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.first_android.artist.Artist
import com.example.first_android.artist.ArtistAPI
import com.example.first_android.artist.ArtistRepository
import com.example.first_android.config.RetrofitBuilder

class FoodViewModel  : ViewModel() {

    private val foodRepository: FoodRepository

    init {
        val foodAPI = RetrofitBuilder.createRetrofit().create(FoodAPI::class.java)
        foodRepository = FoodRepository(foodAPI)
    }

    val food: LiveData<Food> = foodRepository.food

    fun getFood(foodCode: String) {
        foodRepository.getFood(foodCode)
    }
}
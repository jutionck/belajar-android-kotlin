package com.example.first_android.film

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.first_android.config.RetrofitBuilder

class FilmViewModel : ViewModel() {


    private val filmRepository: FilmRepository

    init {
        val userAPI = RetrofitBuilder.createRetrofit().create(FilmAPI::class.java)
        filmRepository = FilmRepository(userAPI)
    }

    val film: LiveData<Film> = filmRepository.film
    val filmList: LiveData<List<Film>> = filmRepository.filmList

    fun getAllFilm() {
        filmRepository.getAllFilm()
    }

    fun getFilmByID(userID: String) {
        filmRepository.getFilmByID(userID)
    }

    fun createFilm(film: Film) {
        filmRepository.saveFilm(film)
    }

}
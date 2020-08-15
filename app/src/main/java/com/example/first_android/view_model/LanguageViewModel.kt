package com.example.first_android.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LanguageViewModel: ViewModel() {

    val languageList: MutableList<String> = mutableListOf("Java", "Python")
    val languageLiveData: MutableLiveData<MutableList<String>> = MutableLiveData(languageList)

    fun addLanguage(name: String) {
        languageList.add(name)
        languageLiveData.value = languageList
    }
}
package com.example.first_android.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.text.FieldPosition

class LanguageViewModel: ViewModel() {

    private val languageList: MutableList<String> = mutableListOf("Java", "Python")
    val languageLiveData: MutableLiveData<MutableList<String>> = MutableLiveData(languageList)

    fun addLanguage(name: String) {
        languageList.add(name)
        languageLiveData.value = languageList
    }

    fun removeLanguage(position: Int) {
        languageList.removeAt(position)
        languageLiveData.value = languageList
    }
}
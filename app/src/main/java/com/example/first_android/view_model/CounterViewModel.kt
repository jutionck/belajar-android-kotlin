package com.example.first_android.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel: ViewModel() {

    var counter: MutableLiveData<Int> = MutableLiveData(0)
    var name: MutableLiveData<String> = MutableLiveData("")

    fun increase() {
        counter.value = counter.value?.plus(1)
    }

    fun decrease() {
        counter.value = counter.value?.minus(1)
    }
}
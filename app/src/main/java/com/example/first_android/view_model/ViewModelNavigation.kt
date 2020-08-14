package com.example.first_android.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelNavigation: ViewModel() {
    val username : MutableLiveData<String> = MutableLiveData("")
    val accountNumber : MutableLiveData<String> = MutableLiveData("")
    val nameBank : MutableLiveData<String> = MutableLiveData("")
    val amountTransfer : MutableLiveData<Int> = MutableLiveData(0)


    fun setInfoAccount(inBankName:String, inAccountNumber:String, inUsername:String){
        username.value=inUsername
        accountNumber.value=inAccountNumber
        nameBank.value=inBankName
    }

    fun setAmountTransfer(inAmountTransfer:Int){
        amountTransfer.value=inAmountTransfer
    }
}
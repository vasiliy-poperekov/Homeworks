package com.example.homeworks.homework10

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Homework10ActivityViewModel : ViewModel() {
    val sweetLiveData: MutableLiveData<Sweet> = MutableLiveData()

    fun getSweetsInLiveData() {
        sweetLiveData.value =
            SweetFactory().createThreeHundredSweets()[SweetFactory().createThreeHundredSweets().size - 1]
    }
}
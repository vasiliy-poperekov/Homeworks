package com.example.homeworks.homework13

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.homeworks.homework10.Sweet
import com.example.homeworks.homework10.SweetFactory

class FragmentWithCodeViewModel : ViewModel() {
    val sweetLiveData: MutableLiveData<MutableList<Sweet>> = MutableLiveData()

    init {
        getSweetsInLiveData()
    }

    private fun getSweetsInLiveData(){
        sweetLiveData.value = SweetFactory().createThreeHundredSweets()
    }
}
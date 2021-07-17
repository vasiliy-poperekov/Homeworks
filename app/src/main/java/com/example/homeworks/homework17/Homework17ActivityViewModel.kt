package com.example.homeworks.homework17

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.homeworks.homework17.data.Currency
import com.example.homeworks.homework17.restApi.CurrencyRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Homework17ActivityViewModel(
    private val currencyRepository: CurrencyRepository
) : ViewModel() {
    val currencyListLiveData: MutableLiveData<List<Currency>> = MutableLiveData()

    init {
        viewModelScope.launch(Dispatchers.Main) {
            currencyListLiveData.value = currencyRepository.getCurrencyList()
        }
    }

    fun getCurrencyListWithLimit(limit: Int){
        viewModelScope.launch(Dispatchers.Main) {
            currencyListLiveData.value = currencyRepository.getCurrencyListOnId(limit)
        }
    }

    fun getCurrencySortedList(limit: Int){
        viewModelScope.launch(Dispatchers.Main) {
            currencyListLiveData.value = currencyRepository.getCurrencySortedList(limit)
        }
    }
}
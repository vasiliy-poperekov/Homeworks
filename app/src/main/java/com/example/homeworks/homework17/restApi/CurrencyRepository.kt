package com.example.homeworks.homework17.restApi

import com.example.homeworks.homework17.data.Currency
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CurrencyRepository(
    private val currencyApi: CurrencyApi
) {

    suspend fun getCurrencyList(): List<Currency> = withContext(Dispatchers.IO){
        currencyApi.getCurrencyList().data.map {
            Currency(it.id, it.name, it.sign, it.symbol)
        }
    }
    suspend fun getCurrencyListOnId(limit: Int): List<Currency> = withContext(Dispatchers.IO){
        currencyApi.getCurrencyList(limit).data.map {
            Currency(it.id, it.name, it.sign, it.symbol)
        }
    }
    suspend fun getCurrencySortedList(limit: Int): List<Currency> = withContext(Dispatchers.IO){
        currencyApi.getCurrencySortedList(limit).data.map {
            Currency(it.id, it.name, it.sign, it.symbol)
        }
    }
}
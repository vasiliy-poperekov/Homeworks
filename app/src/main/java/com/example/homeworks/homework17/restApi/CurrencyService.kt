package com.example.homeworks.homework17.restApi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object CurrencyService {

    private const val BASE_URL = "https://pro-api.coinmarketcap.com/"

    private fun getRetrofit() = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getCurrencyService(): CurrencyApi = getRetrofit().create(CurrencyApi::class.java)
}
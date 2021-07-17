package com.example.homeworks.homework17.restApi

import com.example.homeworks.BuildConfig
import com.example.homeworks.homework17.enteties.CurrencyResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface CurrencyApi {

    @Headers("X-CMC_PRO_API_KEY: ${BuildConfig.API_KEY}")
    @GET("v1/fiat/map")
    suspend fun getCurrencyList(): CurrencyResponse

    @Headers("X-CMC_PRO_API_KEY: ${BuildConfig.API_KEY}")
    @GET("v1/fiat/map")
    suspend fun getCurrencyList(
        @Query("limit") limit: Int
    ): CurrencyResponse

    @Headers("X-CMC_PRO_API_KEY: ${BuildConfig.API_KEY}")
    @GET("v1/fiat/map")
    suspend fun getCurrencySortedList(
        @Query("limit") limit: Int,
        @Query("sort") sort: String = "name"
    ): CurrencyResponse
}
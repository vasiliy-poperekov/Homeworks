package com.example.homeworks.homework17.enteties

import com.google.gson.annotations.SerializedName

data class CurrencyResponse(
    @SerializedName("data")val data: List<CurrencyEntity>,
    @SerializedName("status")val status: Status
)
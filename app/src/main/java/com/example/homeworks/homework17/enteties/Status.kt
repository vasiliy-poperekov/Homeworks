package com.example.homeworks.homework17.enteties

import com.google.gson.annotations.SerializedName

data class Status (
    @SerializedName("timestamp")val timeStamp: String,
    @SerializedName("error_code")val errorCode: Int,
    @SerializedName("error_message")val errorMessage: String,
    @SerializedName("elapsed")val elapsed: Int,
    @SerializedName("credit_count")val creditCount: Int
)
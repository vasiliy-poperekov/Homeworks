package com.example.homeworks.homework16.database

import androidx.room.Entity

@Entity(tableName = "message_table", primaryKeys = ["message", "date"])
data class MessageEntity(
    val message: String,
    val date: String
)
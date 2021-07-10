package com.example.homeworks

import android.app.Application
import androidx.room.Room
import com.example.homeworks.homework16.database.MessageDao
import com.example.homeworks.homework16.database.MessageDatabase
import com.example.homeworks.homework16.database.MessageRepository

class MyApp : Application() {

    private val messageDatabase: MessageDatabase by lazy {
        Room.databaseBuilder(applicationContext, MessageDatabase::class.java, "message_database")
            .build()
    }

    val messageDao: MessageDao by lazy { messageDatabase.messageDao() }

    val messageRepository: MessageRepository by lazy { MessageRepository(messageDao) }

}
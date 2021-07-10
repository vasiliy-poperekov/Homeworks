package com.example.homeworks.homework16.database

import com.example.homeworks.homework16.Message
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MessageRepository(
    private val messageDao: MessageDao
) {

    fun getMessageList(): Flow<MutableList<Message>> =
        messageDao.getMessageList().map {
            it.map {
                Message(it.message, it.date)
            }.toMutableList()
        }

    fun addMessage(message: Message) {
        messageDao.addMessage(MessageEntity(message.message, message.date))
    }

    fun deleteMessage(message: Message) {
        messageDao.deleteMessage(MessageEntity(message.message, message.date))
    }
}
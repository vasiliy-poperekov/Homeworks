package com.example.homeworks.homework16.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface MessageDao {

    @Query("SELECT * FROM message_table")
    fun getMessageList(): Flow<MutableList<MessageEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addMessage(message: MessageEntity)

    @Delete
    fun deleteMessage(message: MessageEntity)
}
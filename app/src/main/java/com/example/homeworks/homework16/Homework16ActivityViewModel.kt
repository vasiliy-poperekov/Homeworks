package com.example.homeworks.homework16

import androidx.lifecycle.*
import com.example.homeworks.homework16.database.MessageDao
import com.example.homeworks.homework16.database.MessageEntity
import com.example.homeworks.homework16.database.MessageRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*

class Homework16ActivityViewModel(
    private val messageRepository: MessageRepository
) : ViewModel() {
    val liveData: LiveData<MutableList<Message>> = messageRepository.getMessageList().asLiveData()

    fun addMessageToDB(message: Message) {
        viewModelScope.launch(Dispatchers.IO) {
            messageRepository.addMessage(message)
        }
    }

    fun deleteMessageFromDB(message: Message) {
        viewModelScope.launch(Dispatchers.IO) {
            messageRepository.deleteMessage(message)
        }
    }
}

class Homework16ActivityViewModelFactory(
    private val messageRepository: MessageRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return Homework16ActivityViewModel(messageRepository) as T
    }
}
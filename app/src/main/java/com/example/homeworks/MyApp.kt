package com.example.homeworks

import android.app.Application
import androidx.room.Room
import com.example.homeworks.homework16.database.MessageDao
import com.example.homeworks.homework16.database.MessageDatabase
import com.example.homeworks.homework16.database.MessageRepository
import com.example.homeworks.homework17.Homework17ActivityViewModel
import com.example.homeworks.homework17.restApi.CurrencyRepository
import com.example.homeworks.homework17.restApi.CurrencyService
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MyApp : Application() {

    private val messageDatabase: MessageDatabase by lazy {
        Room.databaseBuilder(applicationContext, MessageDatabase::class.java, "message_database")
            .build()
    }
    val messageDao: MessageDao by lazy { messageDatabase.messageDao() }
    val messageRepository: MessageRepository by lazy { MessageRepository(messageDao) }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApp)
            modules(listOf(viewModels, repositoryModels, servicesModels))
        }
    }

    private val viewModels = module {
        viewModel { Homework17ActivityViewModel(get()) }
    }

    private val repositoryModels = module {
        factory { CurrencyRepository(get()) }
    }

    private val servicesModels = module{
        single { CurrencyService.getCurrencyService() }
    }
}
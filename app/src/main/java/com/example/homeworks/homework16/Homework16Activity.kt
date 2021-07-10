package com.example.homeworks.homework16

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homeworks.MyApp
import com.example.homeworks.R
import com.example.homeworks.databinding.ActivityHomework16Binding
import java.text.SimpleDateFormat
import java.util.*

class Homework16Activity : AppCompatActivity() {

    private lateinit var binding: ActivityHomework16Binding
    private val liveData: Homework16ActivityViewModel by viewModels {
        Homework16ActivityViewModelFactory((application as MyApp).messageRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomework16Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val messageAdapter = MessagesAdapter(click = { deleteLongClickItem(it) })

        binding.rvSendedMessages.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )

        liveData.liveData.observe(this, {
            messageAdapter.update(it)
        })

        binding.rvSendedMessages.adapter = messageAdapter

        binding.bwAddMessage.setOnClickListener {
            val message = Message(binding.etMessage.text.toString(), SimpleDateFormat("dd.M.yyyy hh:mm").format(Date()))
            liveData.addMessageToDB(message)
        }

    }

    fun deleteLongClickItem(message: Message) {
        liveData.deleteMessageFromDB(message)
    }
}
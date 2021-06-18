package com.example.homeworks.homework10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homeworks.R
import com.example.homeworks.databinding.ActivityHomework10Binding
import com.example.homeworks.databinding.ActivityHomework7Binding
import kotlin.random.Random

class Homework10 : AppCompatActivity() {
    private lateinit var binding: ActivityHomework10Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomework10Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val sweetsList = ArrayList<Sweet>()
        for (x in 1..100) {
            sweetsList.add(Sweet("Mars", Random.nextLong(10000000, 100000000).toString()))
        }
        for (x in 1..100) {
            sweetsList.add(Sweet("Snikers", Random.nextLong(10000000, 100000000).toString()))
        }
        for (x in 1..100) {
            sweetsList.add(Sweet("Picnic", Random.nextLong(10000000, 100000000).toString()))
        }

        val sweetAdapter = SweetAdapter(sweetsList)
        binding.sweetsRecycler.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.sweetsRecycler.adapter = sweetAdapter
    }
}
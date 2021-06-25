package com.example.homeworks.homework10

import  androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homeworks.R
import com.example.homeworks.databinding.ActivityHomework10Binding

class Homework10Activity : AppCompatActivity() {
    private lateinit var binding: ActivityHomework10Binding
    private val myViewModel: Homework10ActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomework10Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val sweetsList = mutableListOf<Sweet>()

        val sweetAdapter = SweetAdapter(sweetsList)
        binding.sweetsRecycler.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.sweetsRecycler.adapter = sweetAdapter

        binding.bvShowSweets.setOnClickListener {
            binding.bvShowSweets.visibility = View.GONE
            myViewModel.sweetLiveData.observe(this, {
                sweetAdapter.updateList(it)
            })
            binding.sweetsRecycler.adapter = sweetAdapter
        }
    }
}
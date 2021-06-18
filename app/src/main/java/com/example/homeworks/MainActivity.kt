package com.example.homeworks

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.homeworks.databinding.ActivityHomework7Binding
import com.example.homeworks.databinding.ActivityMainBinding
import com.example.homeworks.homework10.Homework10
import com.example.homeworks.homework7.Homework7
import com.example.homeworks.homework6.Homework6Activity as Homework6Activity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bvBtnToHomework6.setOnClickListener {
            val intent = Intent(this, Homework6Activity::class.java)
            startActivity(intent)
        }
        binding.bvBtnToHomework7.setOnClickListener {
            val intent = Intent(this, Homework7::class.java)
            startActivity(intent)
        }
        binding.bvBtnToHomework10.setOnClickListener {
            val intent = Intent(this, Homework10::class.java)
            startActivity(intent)
        }
    }
}
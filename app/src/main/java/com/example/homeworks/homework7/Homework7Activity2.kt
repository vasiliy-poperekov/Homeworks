package com.example.homeworks.homework7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homeworks.databinding.ActivityHomework72Binding

class Homework7Activity2 : AppCompatActivity() {
    private lateinit var binding: ActivityHomework72Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomework72Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val user = intent.extras!!.get(Homework7.USER) as Userdata
        binding.tvLogin.text = binding.tvLogin.text.toString().plus(user.login)
        binding.tvPassword.text = binding.tvPassword.text.toString().plus(user.password)

        binding.bvClose.setOnClickListener {
            finish()
        }
    }
}
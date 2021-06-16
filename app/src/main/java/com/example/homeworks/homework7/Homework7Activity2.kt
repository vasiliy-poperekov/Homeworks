package com.example.homeworks.homework7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.homeworks.R
import com.example.homeworks.databinding.ActivityHomework72Binding

class Homework7Activity2 : AppCompatActivity() {
    private lateinit var binding: ActivityHomework72Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomework72Binding.inflate(layoutInflater)
        setContentView(binding.root)

        Glide
            .with(this)
            .load(
                getString(R.string.picture_link)
            )
            .into(binding.ivPicture)

        val user = intent.extras!!.get(Homework7.USER) as Userdata
        binding.tvLogin.text = binding.tvLogin.text.toString().plus(user.login)
        binding.tvPassword.text = binding.tvPassword.text.toString().plus(user.password)

        binding.bvClose.setOnClickListener {
            finish()
        }
    }
}
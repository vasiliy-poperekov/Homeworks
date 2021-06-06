package com.example.homeworks.homework7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.homeworks.R

class Homework7Activity2 : AppCompatActivity() {

    lateinit var login: TextView
    lateinit var password: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homework72)

        login = findViewById(R.id.tv_login)
        password = findViewById(R.id.tv_password)

        val user = intent.extras!!.get(Homework7.USER) as Userdata
        login.text = login.text.toString().plus(user.login)
        password.text = password.text.toString().plus(user.password)
    }
}
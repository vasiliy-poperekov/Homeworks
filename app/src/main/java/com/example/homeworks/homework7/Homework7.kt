package com.example.homeworks.homework7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.homeworks.R

class Homework7 : AppCompatActivity() {

    lateinit var timer: TextView
    lateinit var btnForTimer: Button
    lateinit var login: EditText
    lateinit var password: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homework7)

        timer = findViewById(R.id.tv_timer)
        btnForTimer = findViewById(R.id.tb_btn_for_timer)
        login = findViewById(R.id.et_login)
        password = findViewById(R.id.et_password)

        btnForTimer.setOnClickListener {
            if (timer.text.toString().toInt() > 1) {
                timer.text = (timer.text.toString().toInt() - 1).toString()
            } else {
                timer.visibility = View.GONE
                login.visibility = View.VISIBLE
                password.visibility = View.VISIBLE
                btnForTimer.setBackgroundColor(ContextCompat.getColor(this, R.color.yelow))
                btnForTimer.text = "Войти"
                if (login.text.isNotEmpty() && password.text.isNotEmpty()) {
                    val intent = Intent(this, Homework7Activity2::class.java)
                    intent.putExtra(USER, Userdata(login.text.toString(), password.text.toString()))
                    startActivity(intent)
                }
            }
        }
    }

    companion object {
        const val USER = "user"
    }
}
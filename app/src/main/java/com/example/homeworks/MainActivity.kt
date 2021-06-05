package com.example.homeworks

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.homeworks.homework6.Homework6Activity as Homework6Activity

class MainActivity : AppCompatActivity() {

    lateinit var btnToHm6: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnToHm6 = findViewById(R.id.bv_btn_to_homework6)
        btnToHm6.setOnClickListener {
            val intent = Intent(this, Homework6Activity::class.java)
            startActivity(intent)
        }
    }
}
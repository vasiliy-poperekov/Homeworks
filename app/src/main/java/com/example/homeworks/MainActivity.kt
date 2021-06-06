package com.example.homeworks

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.homeworks.homework7.Homework7
import com.example.homeworks.homework6.Homework6Activity as Homework6Activity

class MainActivity : AppCompatActivity() {

    lateinit var btnToHm6: Button
    lateinit var btnToHm7: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnToHm6 = findViewById(R.id.bv_btn_to_homework6)
        btnToHm7 = findViewById(R.id.bv_btn_to_homework7)

        btnToHm6.setOnClickListener {
            val intent = Intent(this, Homework6Activity::class.java)
            startActivity(intent)
        }
        btnToHm7.setOnClickListener {
            val intent = Intent(this, Homework7::class.java)
            startActivity(intent)
        }
    }
}
package com.example.homeworks

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.homework6.Homework6Activity as Homework6Activity

class MainActivity : AppCompatActivity() {

    lateinit var clickableText:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        clickableText = findViewById(R.id.main_text)
        clickableText.setOnClickListener{
            val intent = Intent(this, Homework6Activity::class.java)
            startActivity(intent)
        }
    }
}
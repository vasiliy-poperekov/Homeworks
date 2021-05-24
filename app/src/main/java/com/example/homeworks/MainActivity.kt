package com.example.homeworks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.Homework2.Automobile
import com.Homework2.Automobiles
import com.Homework3.Dog
import com.Homework3.Elephant

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dog = Dog("Bob", 25.0)
        val elephant = Elephant("Elph", 10.0)

        println("${dog.name} пробежал за ${dog.time()}")
        println("${elephant.name} пробежал за ${elephant.time()}")
    }
}
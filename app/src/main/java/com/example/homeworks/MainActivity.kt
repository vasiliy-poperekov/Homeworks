package com.example.homeworks

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.example.homeworks.databinding.ActivityMainBinding
import com.example.homeworks.homework10.Homework10Activity
import com.example.homeworks.homework13.Homework13Activity
import com.example.homeworks.homework7.Homework7
import com.example.homeworks.homework6.Homework6Activity as Homework6Activity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding

    override fun onClick(view: View) {
        when(view.id){
            R.id.bv_btn_to_homework6->{
                val intent = Intent(this, Homework6Activity::class.java)
                startActivity(intent)}
            R.id.bv_btn_to_homework7->{
                val intent = Intent(this, Homework7::class.java)
                startActivity(intent)}
            R.id.bv_btn_to_homework10->{
                val intent = Intent(this, Homework10Activity::class.java)
                startActivity(intent)}
            R.id.bv_btn_to_homework13->{
                val intent = Intent(this, Homework13Activity::class.java)
                startActivity(intent)}
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bvBtnToHomework6.setOnClickListener {
            onClick(binding.bvBtnToHomework6)
        }
        binding.bvBtnToHomework7.setOnClickListener {
            onClick(binding.bvBtnToHomework7)
        }
        binding.bvBtnToHomework10.setOnClickListener {
            onClick(binding.bvBtnToHomework10)
        }
        binding.bvBtnToHomework13.setOnClickListener {
            onClick(binding.bvBtnToHomework13)
        }
    }
}
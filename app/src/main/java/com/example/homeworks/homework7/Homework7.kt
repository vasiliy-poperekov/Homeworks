package com.example.homeworks.homework7

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.content.ContextCompat
import com.example.homeworks.R
import com.example.homeworks.databinding.ActivityHomework7Binding
import java.io.Serializable

class Homework7 : AppCompatActivity() {
    private lateinit var binding: ActivityHomework7Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomework7Binding.inflate(layoutInflater)
        setContentView(binding.root)

        savedInstanceState?.let {
            binding.tvTimer.text = it.getInt(COUNTER_KEY).toString()
            if (binding.tvTimer.text.toString().toInt() <= 1) {
                reverseBtn()
            }
        }

        binding.tbBtnForTimer.setOnClickListener {
            if (binding.tvTimer.text.toString().toInt() > 1) {
                binding.tvTimer.text = (binding.tvTimer.text.toString().toInt() - 1).toString()
            } else {
                reverseBtn()
                if (binding.etLogin.text.isNotEmpty() && binding.etPassword.text.isNotEmpty()) {
                    val intent = Intent(this, Homework7Activity2::class.java)
                    intent.putExtra(
                        USER,
                        Userdata(
                            binding.etLogin.text.toString(),
                            binding.etPassword.text.toString()
                        )
                    )
                    startActivity(intent)
                }
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(COUNTER_KEY, binding.tvTimer.text.toString().toInt())
        super.onSaveInstanceState(outState)
    }

    private fun reverseBtn() {
        binding.tvTimer.visibility = View.GONE
        binding.etLogin.visibility = View.VISIBLE
        binding.etPassword.visibility = View.VISIBLE
        binding.tbBtnForTimer.text = getString(R.string.enter_text)
        binding.tbBtnForTimer.setBackgroundColor(
            ContextCompat.getColor(
                this,
                R.color.yelow
            )
        )
    }


    companion object {
        private const val COUNTER_KEY = "KEY"
        const val USER = "user"
    }
}
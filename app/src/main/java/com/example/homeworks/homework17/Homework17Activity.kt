package com.example.homeworks.homework17

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.CheckBox
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homeworks.MyApp
import com.example.homeworks.databinding.ActivityHomework17Binding
import org.koin.androidx.viewmodel.ext.android.viewModel

class Homework17Activity : AppCompatActivity() {

    private lateinit var binding: ActivityHomework17Binding
    private val viewModel: Homework17ActivityViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomework17Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val currencyAdapter = CurrencyAdapter()
        binding.rvCurrencyList.adapter = currencyAdapter

        binding.bvThroughLimit.setOnClickListener {
            if(!TextUtils.isDigitsOnly(binding.etCurrencyLimit.text)){
                Toast.makeText(this, "Введите число", Toast.LENGTH_SHORT).show()
            }
            else{
                if(binding.cbSort.isChecked)
                {
                    viewModel.getCurrencySortedList(binding.etCurrencyLimit.text.toString().toInt())
                }
                else{
                    viewModel.getCurrencyListWithLimit(binding.etCurrencyLimit.text.toString().toInt())
                }
            }
        }

        viewModel.currencyListLiveData.observe(this, {
            currencyAdapter.submitList(it.toMutableList())
        })
    }
}
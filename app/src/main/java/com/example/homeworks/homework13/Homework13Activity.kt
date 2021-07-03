package com.example.homeworks.homework13

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.example.homeworks.databinding.ActivityHomework13Binding

class Homework13Activity : AppCompatActivity() {

    lateinit var binding: ActivityHomework13Binding
    lateinit var bundle: Bundle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomework13Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref = getSharedPreferences(SweetInfoFragment.PREF_KEY, MODE_PRIVATE)
        Toast.makeText(
            this,
            "${sharedPref.getString(SweetInfoFragment.BRAND, "No brand")}, " +
                    "${sharedPref.getString(SweetInfoFragment.CODE, "No code")}",
            Toast.LENGTH_SHORT
        ).show()

        binding.bvShowFragment.setOnClickListener {
            binding.bvShowFragment.visibility = View.GONE
            createFragment()
        }
    }

    fun createFragment() {
        val fragment1 = FragmentWithCodes({ reverseFragment() })
        supportFragmentManager.beginTransaction()
            .add(binding.fragmentsContainer.id, fragment1, FragmentWithCodes.FIRST_FRAG_TAG)
            .addToBackStack(null)
            .commit()
    }

    fun reverseFragment() {
        supportFragmentManager.beginTransaction()
            .replace(
                binding.fragmentsContainer.id,
                SweetInfoFragment(),
                FragmentWithCodes.FIRST_FRAG_TAG
            )
            .addToBackStack(null)
            .commit()
    }
}
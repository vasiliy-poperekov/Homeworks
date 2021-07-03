package com.example.homeworks.homework13

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.homeworks.R
import com.example.homeworks.databinding.FragmentSweetsInfoBinding
import com.example.homeworks.homework10.Sweet

class SweetInfoFragment : Fragment() {

    var binding: FragmentSweetsInfoBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSweetsInfoBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = (activity as Homework13Activity).bundle
        this.arguments = bundle
        val sweet = (arguments?.get(FragmentWithCodes.CLICKED_SWEET) as Sweet)
        binding!!.brand.text = sweet.brand
        binding!!.code.text = sweet.code
        Glide.with(binding!!.sweetsImage).load(sweet.urlPackage).into(binding!!.sweetsImage)

        val anim = AnimationUtils.loadAnimation(binding!!.root.context, R.anim.anim_sweets_picture)
        binding!!.sweetsImage.startAnimation(anim)

        val sharedPref =
            binding!!.root.context.getSharedPreferences(PREF_KEY, AppCompatActivity.MODE_PRIVATE)
        sharedPref.edit().putString(BRAND, sweet.brand).commit()
        sharedPref.edit().putString(CODE, sweet.code).commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        const val PREF_KEY = "PREF_KEY"
        const val CODE = "CODE"
        const val BRAND = "BRAND"
    }
}
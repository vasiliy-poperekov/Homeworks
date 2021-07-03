package com.example.homeworks.homework13

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.homeworks.databinding.FragmentSweetsInfoBinding
import com.example.homeworks.homework10.Sweet

class SweetInfoFragment: Fragment() {

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
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
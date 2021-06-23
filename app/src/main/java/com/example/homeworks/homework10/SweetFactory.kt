package com.example.homeworks.homework10

import android.content.Context
import com.example.homeworks.R
import kotlin.random.Random

class SweetFactory(val context: Context? = null) {
    val sweetsList = mutableListOf<Sweet>()
    fun createThreeHundredSweets(): MutableList<Sweet> {
        for (i in 1..SWEETSNUMBER) {
            when (i) {
                in 1..100 -> sweetsList.add(
                    Sweet(
                        "Mars",
                        Random.nextLong(10000000, 100000000).toString(),
                        context?.getString(R.string.mars_img_url) ?: ""
                    )
                )
                in 101..200 -> sweetsList.add(
                    Sweet(
                        "Snikers",
                        Random.nextLong(10000000, 100000000).toString(),
                        context?.getString(R.string.snikers_img_url) ?: ""
                    )
                )
                in 201..300 -> sweetsList.add(
                    Sweet(
                        "Picnic",
                        Random.nextLong(10000000, 100000000).toString(),
                        context?.getString(R.string.picnic_img_url) ?: ""
                    )
                )
            }
        }
        return sweetsList
    }

    companion object {
        const val SWEETSNUMBER = 300
    }
}
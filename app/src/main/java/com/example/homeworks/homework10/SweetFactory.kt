package com.example.homeworks.homework10

import android.content.Context
import com.example.homeworks.R
import kotlin.random.Random

class SweetFactory {

    fun createThreeHundredSweets(): MutableList<Sweet> {
        val sweetsList = mutableListOf<Sweet>()
        for (i in 1..SWEETSNUMBER) {
            when (i) {
                in 1..100 -> sweetsList.add(
                    Sweet(
                        "Mars",
                        Random.nextLong(10000000, 100000000).toString(),
                        "https://images-na.ssl-images-amazon.com/images/I/41AeTKhQ8vL._AC_.jpg"
                    )
                )
                in 101..200 -> sweetsList.add(
                    Sweet(
                        "Snikers",
                        Random.nextLong(10000000, 100000000).toString(),
                        "https://snickers.ru/static/media/pr-26.f475d7bd.png"
                    )
                )
                in 201..300 -> sweetsList.add(
                    Sweet(
                        "Picnic",
                        Random.nextLong(10000000, 100000000).toString(),
                        "https://www.treasureislandsweets.co.uk/user/products/large/cadbury_picnic_bar.jpg"
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
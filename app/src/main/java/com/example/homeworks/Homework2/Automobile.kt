package com.example.homeworks.Homework2

class Automobile(
    private val brand: String,
    private var color: String = "Black",
    private val engineDisplacement: Double,
    private var number: String? = null
) {
    override fun toString(): String {
        return "Automobile(brand='$brand', color='$color', engineDisplacement=$engineDisplacement, number=${number ?: "Transit"})"
    }
}
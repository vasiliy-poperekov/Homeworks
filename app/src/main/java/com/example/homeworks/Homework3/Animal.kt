package com.example.homeworks.Homework3

open class Animal(private val speed: Double) {
    fun time(): Double = CONSTDISTANCE / speed

    companion object {
        const val CONSTDISTANCE = 1080.0
    }
}
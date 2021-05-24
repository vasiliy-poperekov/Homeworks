package com.Homework3

open class Animal(private val speed:Double) {
    public fun time (distance:Double=CONSTDISTANCE):Double=distance/speed

    companion object{
        const val CONSTDISTANCE = 1080.0
    }
}
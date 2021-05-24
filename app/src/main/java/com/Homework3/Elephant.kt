package com.Homework3

class Elephant(private val name:String):Animal(10.0) {
    override fun toString(): String {
        return "$name пробежал за ${time(1000.0)} часа"
    }
}
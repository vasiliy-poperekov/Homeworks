package com.Homework3

class Dog(private val name:String): Animal(25.0) {
    override fun toString(): String {
        return "$name пробежал за ${time(1000.0)} часа"
    }
}
package com.example.homeworks.homework4

class Worker(
    var nameW: String,
    var moneyW: Int
) : Employee(nameW, moneyW) {
    fun work() {
        println(" $nameW работает")
    }
}
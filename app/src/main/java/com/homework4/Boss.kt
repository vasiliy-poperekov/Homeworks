package com.homework4

class Boss(
    var nameB: String,
    var moneyB: Int,
    var menegersList: ArrayList<Manager>
) : Employee(nameB, moneyB) {
}
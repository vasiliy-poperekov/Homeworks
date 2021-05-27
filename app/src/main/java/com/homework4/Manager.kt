package com.homework4

class Manager(
    var nameM: String,
    var moneyM: Int,
    var workersList: ArrayList<Worker>
) : Employee(nameM, moneyM) {
}
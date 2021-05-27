package com.example.homeworks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.homework4.Boss
import com.homework4.Employee
import com.homework4.Manager
import com.homework4.Worker

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val workersList = arrayListOf(
            Worker("Peter", 1100),
            Worker("Nikolay", 1000),
            Worker("Andrew", 900),
            Worker("Vasiliy", 1050),
            Worker("Grigory", 950)
        )

        val managersList = arrayListOf(
            Manager("Oleg", 2000, arrayListOf(workersList[0], workersList[1], workersList[2])),
            Manager("John", 2100, arrayListOf(workersList[2], workersList[3], workersList[4])),
            Manager("Bob", 2050, arrayListOf(workersList[0], workersList[3], workersList[1])),
            Manager("Stas", 1950, arrayListOf(workersList[4], workersList[2], workersList[0]))
        )

        val bossesList = arrayListOf(
            Boss("Dmitry", 10000, arrayListOf(managersList[0], managersList[1])),
            Boss("Mikhail", 10001, arrayListOf(managersList[2], managersList[3]))
        )

        val employees = mutableListOf<Employee>()
        workersList.forEach() {
            employees.add(it)
        }
        managersList.forEach() {
            employees.add(it)
        }
        bossesList.forEach() {
            employees.add(it)
        }

        employees.forEach() {
            print("${it.name} зарплата = ${it.money}")
            if (it is Boss) print(" кол-во подчтнённых = ${(it as Boss).menegersList.size}")
            else if (it is Manager) print(" кол-во подчтнённых = ${(it as Manager).workersList.size}")
            else if (it is Worker) (it as Worker).work()
            println()
        }
    }
}
package com.Homework2

object Automobiles {
    fun automobilesCreatorAndPrinter() {
        val cars = listOf(
            Automobile(brand = "Toyota", engineDisplacement = 100.1),
            Automobile("Porshe", "Red", 200.2, "A111AA"),
            Automobile("BMW", "Blue", 300.3, "B222BB"),
            Automobile("Nissan", "Yellow", 123.1),
            Automobile("Reno", "Green", 456.2, "M345CK"),
            Automobile("VolksWagen", "White", 202.2, "M432CD")
        )
        for (car in cars) {
            println(car)
        }
    }
}
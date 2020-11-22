package com.skillbox.homework6

fun main() {
    val person1 = Person(180, 80, "Nick")
    val person2 = Person(180, 80, "Nick")
    val person3 = Person(170, 70, "Max")
    val person4 = Person(170, 70, "Alex")

    val hs = hashSetOf(
            person1,
            person2,
            person3,
            person4
    )

    hs.forEach() {
        println(it.toString())
    }

    person1.buyPet(4)
    person3.buyPet(5)
    person4.buyPet(2)
}
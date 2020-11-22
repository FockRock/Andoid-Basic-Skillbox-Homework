package com.skillbox.homework6

fun main() {
    val person1 = Person(180, 80, "Nick")
    val person2 = Person(180, 80, "Nick")
    val person3 = Person(170, 70, "Max")

    val hs = hashSetOf(
            person1,
            person2,
            person3
    )

    person1.buyPet()
    person1.buyPet()
    person1.buyPet()

    hs.forEach() {
        println(it.toString())
    }
}
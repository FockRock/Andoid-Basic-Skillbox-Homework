package com.skillbox.homework6

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

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

    person1.buyPet()
    person3.buyPet()
    person4.buyPet()
    person3.buyPet()
    person1.buyPet()
    person4.buyPet()
    person3.buyPet()
}

class PrintPets <T> (private val value: T) : ReadOnlyProperty <Person, T> {
    override fun getValue(thisRef: Person, property: KProperty<*>): T {
        println("${thisRef.name} buy a pet. He has $value")
        return value
    }

}
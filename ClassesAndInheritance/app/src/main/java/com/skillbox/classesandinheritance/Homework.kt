package com.skillbox.classesandinheritance

fun main() {
    var tiger = Animal(
            12,30, 1, "Tiger"
    )
    println("${tiger.name} age is now ${tiger.age}.")
    tiger.sleep()
    tiger.eat()
    tiger.move()
    println("${tiger.name} age is now ${tiger.age}.")
}
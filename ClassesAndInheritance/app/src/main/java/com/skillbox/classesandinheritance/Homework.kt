package com.skillbox.classesandinheritance

fun main() {
    var animal = Animal(12,30, 10, "Tiger")

    while (!animal.isTooOld) {
        animal.sleep()
        animal.eat()
        animal.move()
        }
        animal.makeChild()
}
package com.skillbox.classesandinheritance

class Dog constructor(
        energy: Int,
        weight: Int,
        maxAge: Int,
        name: String
): Animal(energy, weight, maxAge, name) {

    override fun move() {
        if (!isTooOld && energy >= 5 && weight >= 1) {
            energy -= 5
            weight --
            incrementAgeSometimes()
            println("$name running.")
        } else return
    }
}
package com.skillbox.classesandinheritance

class Bird constructor(
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
            println("$name flying.")
        } else return
    }
}
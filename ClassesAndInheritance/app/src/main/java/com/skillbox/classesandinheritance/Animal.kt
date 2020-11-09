package com.skillbox.classesandinheritance

import kotlin.random.Random

class Animal constructor(
        var energy: Int,
        var weight: Int,
        private val maxAge: Int,
        val name: String,
        var age: Int = 0
){
    val isTooOld: Boolean
        get() =
            if (age >= maxAge) true else false


    fun sleep(){
        if (!isTooOld)
            energy += 5
            age ++
            println("$name sleeping.")
    }

    fun eat() {
        if (!isTooOld)
            energy += 3
            weight ++
            incrementAgeSometimes()
            println("$name eats.")
    }

    private fun incrementAgeSometimes() {
        if (Random.nextBoolean()) {
            age++
        }
    }

    fun move() {
        if (!isTooOld && energy <= 5 && weight <= 1)
            energy -= 5
            weight --
            incrementAgeSometimes()
            println("$name moving.")
    }
}
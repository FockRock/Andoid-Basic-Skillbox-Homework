package com.skillbox.classesandinheritance

import kotlin.random.Random

abstract class Animal constructor(
        energy: Int,
        weight: Int,
        maxAge: Int,
        val name: String
): AgedAnimal(maxAge) {
    var energy = energy
        private set

    var weight = weight
        private set

    var age: Int = 0

    val isTooOld: Boolean
        get() = age >= maxAge

    fun sleep(){
        if (!isTooOld) {
            energy += 5
            age ++
            println("$name sleeping.")
        } else return
    }

    fun eat() {
        if (!isTooOld) {
            energy += 3
            weight++
            incrementAgeSometimes()
            println("$name eats.")
        } else return
    }

    private fun incrementAgeSometimes() {
        if (Random.nextBoolean()) {
            age++
        }
    }

    open fun move() {
        if (!isTooOld && energy >= 5 && weight >= 1) {
            energy -= 5
            weight --
            incrementAgeSometimes()
            println("$name moving.")
        } else return
    }

    open fun makeChild(): Animal {
        val newEnergy: Int = Random.nextInt(until = 10) + 1
        val newWeight: Int = Random.nextInt(until = 5) + 1
        val animal = object : Animal(newEnergy,newWeight, this@Animal.maxAge, this.name) {}
        println("${animal.name} was born. It has ${animal.energy} energy," +
                "${animal.weight} weight and max age is ${animal.maxAge}.")
        return animal
    }
}
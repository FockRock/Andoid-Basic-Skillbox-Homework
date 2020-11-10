package com.skillbox.classesandinheritance

import kotlin.random.Random

class Animal constructor(
        energy: Int,
        weight: Int,
        maxAge: Int,
        name: String
){  var energy = energy
        private set

    var weight = weight
        private set

    var age: Int = 0

    private val maxAge = maxAge

    val name = name

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

    fun move() {
        if (!isTooOld && energy >= 5 && weight >= 1) {
            energy -= 5
            weight --
            incrementAgeSometimes()
            println("$name moving.")
        } else return
    }

    fun makeChild(): Animal {
        val newEnergy: Int = Random.nextInt(until = 10) + 1
        val newWeight: Int = Random.nextInt(until = 5) + 1
        val animal = Animal(newEnergy,newWeight,this.maxAge,this.name)
        println("${animal.name} was born. It has ${animal.energy} energy, ${animal.weight} weight and " +
                "max age is ${animal.maxAge}.")
        return animal
    }
}
package com.skillbox.classesandinheritance

import kotlin.random.Random

class Fish constructor(
        energy: Int,
        weight: Int,
        private val maxAge: Int,
        name: String
): Animal(energy, weight, maxAge, name) {

    override fun move() {
        super.move()
        println("Fish is swimming.")
    }

    override fun makeChild(): Fish {
        val newEnergy: Int = Random.nextInt(until = 10) + 1
        val newWeight: Int = Random.nextInt(until = 5) + 1
        val fish = Fish(newEnergy,newWeight, this.maxAge, this.name)
        println("${fish.name} was born. It has ${fish.energy} energy," +
                "${fish.weight} weight and max age is ${fish.maxAge}.")
        return fish
    }
}
package com.skillbox.classesandinheritance

import kotlin.random.Random

class Dog constructor(
        energy: Int,
        weight: Int,
        override val maxAge: Int,
        name: String
): Animal(energy, weight, maxAge, name), Soundable {

    override fun move() {
        super.move()
        println("Dog is running.")
    }

    override fun makeSound() {
        println("Woof-Woof!")
    }

    override fun makeChild(): Dog {
        val newEnergy: Int = Random.nextInt(until = 10) + 1
        val newWeight: Int = Random.nextInt(until = 5) + 1
        val dog = Dog(newEnergy,newWeight, this.maxAge, this.name)
        println("${dog.name} was born. It has ${dog.energy} energy," +
                "${dog.weight} weight and max age is ${dog.maxAge}.")
        return dog
    }
}
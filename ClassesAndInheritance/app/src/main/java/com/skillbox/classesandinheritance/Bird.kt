package com.skillbox.classesandinheritance

import kotlin.random.Random

class Bird constructor(
        energy: Int,
        weight: Int,
        override val maxAge: Int,
        name: String
): Animal(energy, weight, maxAge, name), Soundable {

    override fun move() {
        super.move()
        println("Bird is flying.")
    }

    override fun makeSound() {
        println("PiPiPi!")
    }

    override fun makeChild(): Bird {
        val newEnergy: Int = Random.nextInt(until = 10) + 1
        val newWeight: Int = Random.nextInt(until = 5) + 1
        val bird = Bird(newEnergy,newWeight, this.maxAge, this.name)
        println("${bird.name} was born. It has ${bird.energy} energy," +
                "${bird.weight} weight and max age is ${bird.maxAge}.")
        return bird
    }
}
package com.skillbox.homework6

import kotlin.random.Random
import kotlin.random.nextInt

class Person (
    var height: Int,
    var weight: Int,
    var name: String
) {

    val pets = hashSetOf<Animal>()

    fun buyPet() {
        val randomEnergy = Random.nextInt(1..100)
        val randomWeight = Random.nextInt(1..100)
        val randomName = ("Pet №" + Random.nextInt(1..100).toString())
        val animal = Animal(randomEnergy,randomWeight,randomName)
        pets.add(animal)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Person

        if (height != other.height) return false
        if (weight != other.weight) return false
        if (name != other.name) return false
        if (pets != other.pets) return false

        return true
    }

    override fun hashCode(): Int {
        var result = height
        result = 31 * result + weight
        result = 31 * result + name.hashCode()
        result = 31 * result + pets.hashCode()
        return result
    }

    override fun toString(): String {
        return "Person(height=$height, weight=$weight, name='$name', pets=$pets)"
    }
}
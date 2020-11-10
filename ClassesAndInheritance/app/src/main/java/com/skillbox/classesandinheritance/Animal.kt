package com.skillbox.classesandinheritance

import kotlin.random.Random

class Animal constructor(
        val e: Int,
        val w: Int,
        val mA: Int,
        val n: String
){  var energy = this.e
        private set

    var weight = this.w
        private set

    var age: Int = 0

    private val maxAge = this.mA

    val name = this.n

    val isTooOld: Boolean
        get() {
            return age >= maxAge
        }

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
        if (!isTooOld && energy <= 5 && weight <= 1) {
            energy -= 5
            weight --
            incrementAgeSometimes()
            println("$name moving.")
        } else return
    }
}
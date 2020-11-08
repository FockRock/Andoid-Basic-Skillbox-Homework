package com.skillbox.classesandinheritance

class Animal constructor(
        var energy: Int,
        var weight: Int,
        val maxAge: Int,
        val name: String,
        var age: Int = 0
){
    val isTooOld: Boolean {if age >= maxAge true else false}

    public fun sleep(){
        energy =+ 5
        age =+ 1
        println("$name sleeping.")
    }
}
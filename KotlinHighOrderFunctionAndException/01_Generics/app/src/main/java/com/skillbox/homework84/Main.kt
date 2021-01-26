package com.skillbox.homework84

fun main() {

    val newList: GenericClass<Double> =

    println(oddList())
}

class GenericClass<out T: Number>() {

}

fun oddList(newList: GenericClass<Number>): List<Int> {
    val oddList: List<Int> = listOf()


    return oddList
}
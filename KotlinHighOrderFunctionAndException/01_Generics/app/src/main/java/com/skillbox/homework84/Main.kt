package com.skillbox.homework84

fun main() {

    val list: List<Int> = listOf(1,2,4,5,6)
    println(oddList(list))
}

class GenericList<T: Number>()

fun oddList(list: GenericList<Number>): List<Number> {
    var newList: List<Number>

    for (t in list)
        if (t % 2 == 0)
}
package com.skillbox.homework84

fun main() {
    val newList = mutableListOf(4.36, 5, 7, 9, 6, 9223372036854775806, 5.4, 5.8, 4.63, 12.0, 136, 289, 37.4)
    oddList(newList)

    val newQueue: Queue<String> = Queue(mutableListOf("one", "two", "three"))
    newQueue.enqueue("four")
    println(newQueue.dequeue())
    println(newQueue.dequeue())
    println(newQueue.dequeue())
    println(newQueue.dequeue())
    println(newQueue.dequeue())
}

fun <T: Number>oddList(newList: MutableList<T>): MutableList<T> {
    val oddList: MutableList<T> = mutableListOf()

    for (t in newList) {
        if (t is Long) {
            if (t % 2 == 0L) {
                oddList.add(t)
            }
        } else {
            if (t.toDouble() % 2 == 0.0) {
                oddList.add(t)
            }
        }
    }

    println("Целые числа: ${newList.filter { it.toDouble() - it.toLong() == 0.0 }}")
    println("Вещественные числа: ${newList.filter { it.toDouble() - it.toLong().toDouble() != 0.0 }}")   //Вычисляет, остается ли хвост у числа. Если да, то это дробное число
    println("Четные числа: $oddList")

    return oddList
}
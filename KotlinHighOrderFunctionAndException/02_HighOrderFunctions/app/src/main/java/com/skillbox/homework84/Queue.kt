package com.skillbox.homework84

fun main() {

    val newQueue = Queue(mutableListOf("Nick", "Max", "Alex", "Dan", "Stan"))

    val filtered = {q: Queue<String> -> Queue<String>::filter}

    println(filtered(newQueue))
    println(newQueue.filter())
}

class Queue<T> (private val queueList: MutableList<T>) {

    fun enqueue(item: T) {
        queueList.add(item)
        println(queueList)
    }

    fun dequeue(): T? {
        var a: T? = null

        if (queueList.size > 0) {
            a = queueList[0]
            queueList.remove(a)
        }
        return a
    }

    fun filter() = queueList.filter { it.toString().length == 4 }
}
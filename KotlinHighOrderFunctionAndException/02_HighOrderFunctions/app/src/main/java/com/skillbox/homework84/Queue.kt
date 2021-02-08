package com.skillbox.homework84

fun main() {

    val newQueue = Queue<String>()
    newQueue.queueList = mutableListOf("Nick", "Max", "Alex")

    val filteredQueue = newQueue.queueList.filter { it.length == 4 }

    println(filteredQueue)
}

class Queue <T> () {

    var queueList: MutableList<T> = mutableListOf()

    private fun enqueue(item: T) {
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

    fun filter (condition: (T) -> Boolean): Queue<T> {
        val newQueue: Queue<T> = Queue()
        for (e in queueList) {
            if (condition(e))
                newQueue.enqueue(e)
        }
        return newQueue
    }
}
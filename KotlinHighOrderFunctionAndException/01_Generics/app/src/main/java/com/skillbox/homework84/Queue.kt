package com.skillbox.homework84

class Queue<T> (var queueList: MutableList<T>) {

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
}
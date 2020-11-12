package com.skillbox.classesandinheritance

import kotlin.random.Random

fun main() {
    var zoo = Zoo()

    print("Введите число: ")
    var n: Int = readLine()?.toIntOrNull()?: return

    while (n > 0) {
        if (zoo.animalList.size > 0) {
            zoo.animalList.forEach() {
                if (!it.isTooOld) {
                    when (Random.nextInt(until = 4)) {
                        0 -> it.eat()
                        1 -> it.move()
                        2 -> it.sleep()
                        3 -> zoo.animalList.add(it.makeChild())
                    }
                } else zoo.animalList.remove(it)
            }
            n--
            println("Осталось живых животных в зоопарке ${zoo.animalList.size}")
        } else println("В зоопарке пусто!")
    }

}
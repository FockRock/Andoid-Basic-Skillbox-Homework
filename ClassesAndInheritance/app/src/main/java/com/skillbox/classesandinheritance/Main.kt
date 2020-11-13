package com.skillbox.classesandinheritance

import kotlin.random.Random

fun main() {
    val zoo = Zoo()

    print("Введите число: ")
    var n: Int = readLine()?.toIntOrNull()?: return

    while (n > 0) {
        if (zoo.animalList.size > 0) {
            val newList = mutableListOf<Animal>()
            val deadList = mutableListOf<Animal>()
            zoo.animalList.forEach() {

                if (it is Soundable) {
                    val sound = Random.nextBoolean()        //Может издать звук
                    if (sound) it.makeSound()
                }

                if (!it.isTooOld) {
                    when (Random.nextInt(until = 4)) {
                        0 -> it.eat()
                        1 -> it.move()
                        2 -> it.sleep()
                        3 -> newList.add(it.makeChild())            //Добавляет ребенка в новый список
                    }
                }
                else deadList.add(it)                               //Добавляет в список мертвых
            }
            zoo.animalList.removeAll(deadList)
            zoo.animalList.addAll(newList)
            n--
            println("Осталось живых животных в зоопарке: ${zoo.animalList.size}," +
                    "родилось за все время: ${newList.size}, умерло за все время: ${deadList.size}")
        } else println("В зоопарке пусто!")
    }

}
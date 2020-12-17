package com.skillbox.homework7

import kotlin.random.Random

open class Team (
        private var numberOfWarriors: Int = readLine()!!.toInt()
        ){

    var warriorList = mutableListOf<Warrior>()                                                      //Создаем список войнов

    fun getArmy(num: Int = numberOfWarriors): MutableList<Warrior> {                        //Ф-ия случайного получения война
        var a = num
        while (a > 0) {
            when {
                10 >= Random.nextInt(100) -> {
                    println("General added to team")
                    warriorList.add(General())
                }
                40 >= Random.nextInt(100) -> {
                    println("Captain added to team")
                    warriorList.add(Captain())
                }
                else -> {
                    println("Soldier added to team")
                    warriorList.add(Soldier())
                }
            }
            a--
        }
        println("Team was Created!")
        return warriorList
    }
}
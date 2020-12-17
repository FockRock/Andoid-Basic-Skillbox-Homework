package com.skillbox.homework7

import kotlin.random.Random

class Team (
        private val numberOfWarriors: Int
        ){
    var warriorList = mutableListOf<Warrior>()                                                      //Создаем список войнов

    private fun getArmy(num: Int = numberOfWarriors): MutableList<Warrior> {                        //Ф-ия случайного получения война
        var a = num
        while (a > 0) {
            if (10 >= Random.nextInt(100)) {
                println("General added to team")
                warriorList.add(General())
            } else if (40 >= Random.nextInt(100)) {
                println("Captain added to team")
                warriorList.add(Captain())
            } else {
                println("Soldier added to team")
                warriorList.add(Soldier())
            }
            a--
        }
        return warriorList
    }
}
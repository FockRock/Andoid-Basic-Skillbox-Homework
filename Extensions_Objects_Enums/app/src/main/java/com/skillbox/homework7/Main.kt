package com.skillbox.homework7

import kotlin.random.Random

fun main() {
    println("Введите количество войнов в первой и второй команде команде:")
    val war = Battle(Team(), Team(), false)
    war.team1.getArmy()
    war.team2.getArmy()
}

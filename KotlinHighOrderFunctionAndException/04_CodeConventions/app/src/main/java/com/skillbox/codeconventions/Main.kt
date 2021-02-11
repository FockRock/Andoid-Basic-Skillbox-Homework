package com.skillbox.homework7

fun main() {
    println("Введите количество войнов в первой и второй команде команде:")

    val war = Battle(Team(), Team(), false)

    war.battleIteration()
}

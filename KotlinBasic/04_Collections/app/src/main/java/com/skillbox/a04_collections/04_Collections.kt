package com.skillbox.a04_collections

import android.renderscript.Sampler
import java.security.Key

fun main() {
    print("Введите число: ")
    val n: Int = readLine()?.toIntOrNull()?: return

    if (n > 0) {
        println("Введите $n номеров телефонов:")
    } else println("Вы ввели неверное число.")

    val phoneList = phoneListAdd(n)
    val truePhoneList = phoneList.filter { it.startsWith("+7") }
    println("Из них настоящие номера, начинающиеся на +7: $truePhoneList")

    val phoneSet = truePhoneList.toMutableSet()
    val x = phoneSet.size
    println("Количество уникальных телефонов: $x")

    println("Длина всех номеров телефонов: ${truePhoneList.sumBy { it.length }}")

    var phoneMap = mutableMapOf<String, String>()

    for (newNumber in phoneSet) {
        println("Введите имя человека с номером телефона $newNumber: ")
        val phoneName: String = readLine().toString()
        phoneMap[newNumber] = phoneName
    }

    for (keys in phoneMap.keys) {
        println("Человек: ${phoneMap[keys]}. Номер телефона: $keys")
    }
}

fun phoneListAdd (phoneNumbers: Int): List<String> {
    val phoneList = mutableListOf<String>()
    var num = phoneNumbers

    while (num > 0) {
        val currentNumber = readLine().toString()
        phoneList.add(currentNumber)
        num--
    }
    return phoneList
    }
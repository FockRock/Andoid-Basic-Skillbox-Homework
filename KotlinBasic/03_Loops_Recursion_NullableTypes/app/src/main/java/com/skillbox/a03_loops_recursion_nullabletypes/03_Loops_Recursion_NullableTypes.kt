package com.skillbox.a03_loops_recursion_nullabletypes

fun main() {
    print("Введите число: ")
    var n: Int = readLine()?.toIntOrNull()?: return

    if (n > 0) {
        println("Введите еще $n чисел.")
    } else println("Вы ввели неверное число.")

    var sum = 0
    var numbers = 0

    while (n > 0) {
        val currentNumber = readLine()?.toIntOrNull()?: continue
        sum += currentNumber
        n--
        if (currentNumber > 0) {
            numbers++
        } else continue
    }
    println("Количество введенных положительных чисел = $numbers")
    println("Сумма чисел $sum")

    print("Введите число для вычисления НОД: ")
    val x: Int = readLine()?.toIntOrNull()?: return

    val nod = calculateNod(x, sum)
    print("НОД этого числа и суммы других чисел равен $nod")
}


tailrec fun calculateNod(a: Int, b: Int): Int {
    return if (b == 0) a else calculateNod(b, a % b)
}
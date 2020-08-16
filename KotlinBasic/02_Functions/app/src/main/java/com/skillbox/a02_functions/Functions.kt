package com.skillbox.a02_functions
import kotlin.math.sqrt

fun main() {
    val solutionSum = solveEquation(a=3, b=56, c=7)
    println("Сумма корней ровна $solutionSum")
}

fun solveEquation (a: Int, b: Int, c: Int): Float {

    println("$a x^2 ${if(b>=0)"+ $b" else "$b"} x ${if(c>=0)"+ $c" else "$c"} = 0")

    val d: Float = (b*b) - (4F*(a*c))         //формула расчета дискриминанта
        println("Дискриминант равен $d")
    val x1: Float
    val x2: Float

    if (d > 0) {
        x1 = ((-1 * b) + sqrt(d)) / 2 * a   //расчет первого корня
        println("X1 = $x1")

        x2 = ((-1 * b) - sqrt(d)) / 2 * a   //расчет второго корня
        println("X2 = $x2")
    } else {
        x1 = 0F
        x2 = 0F
    }
    return x1 + x2                          //расчет суммы корней
}
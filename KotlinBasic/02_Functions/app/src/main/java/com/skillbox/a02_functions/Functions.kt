package com.skillbox.a02_functions
import kotlin.math.sqrt

fun main() {
    val solutionSum = solveEquation(a=8, b=67, c=12)
    println("Сумма корней ровна $solutionSum")
}

fun solveEquation (a: Int, b: Int, c: Int): Float {

    println("$a x^2 ${if(b>=0)"+ $b" else "$b"} x ${if(c>=0)"+ $c" else "$c"} = 0")

    val d: Float = (b*b) - (4f*(a*c))                  //формула расчета дискриминанта
        println("Дискриминант равен $d")
    val x1: Any
    val x2: Any

    when {
        d > 0 -> {
            x1 = ((-1 * b) + sqrt(d)) / (2 * a)     //расчет первого корня
            println("X1 = $x1")

            x2 = ((-1 * b) - sqrt(d)) / (2 * a)     //расчет второго корня
            println("X2 = $x2")
        }
        d < 0 -> {
            x1 = 0f
            x2 = 0f
        }
        else -> {
            x1 = (-1f * b) / (2f * a)
            x2 = 0f
        }
    }

    return x1 + x2                                   //расчет суммы корней
}
package com.skillbox.exceptions

fun main() {
    val wheel = Wheel()
    try {
        wheel.setPressure(15.0)
    } catch (e: Exception) {
        println("Pressure is too HIGH")
    }
    try {
        wheel.setPressure(-4.0)
    } catch (e: Exception) {
        println("Pressure is too LOW")
    }
    wheel.setPressure(3.0)
    println("Pressure is OK")
}

class Wheel {
    var pressure: Double = 0.0
        private set

    class TooHighPressure: Exception()
    class TooLowPressure: Exception()
    class IncorrectPressure: Exception()

    fun setPressure(value: Double) {
        pressure = value
        if (value < 0) {
            throw TooLowPressure()
        } else if (value > 10) {
            throw TooHighPressure()
        }
    }

    fun check() {
        if (pressure > 10 || pressure < 0) throw IncorrectPressure()
    }
} 
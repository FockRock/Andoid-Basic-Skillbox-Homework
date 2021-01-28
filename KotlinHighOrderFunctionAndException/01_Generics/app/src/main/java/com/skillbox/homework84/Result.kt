package com.skillbox.homework84

import kotlin.random.Random

sealed class Result<out T, R> {

    data class Success<T, R>(
            val a: T
    ): Result<T, R>()

    data class Error<T, R>(
            val b: R
    ): Result<T, R>()

    fun result(): Result<Int, String> {

        val a = Success<Int, String>(34)
        val b = Error<Int, String>("generic")

        val r: Result<Int, String>
        val choice = Random.nextBoolean()
        r = if (choice) a else b

        return r
    }
}
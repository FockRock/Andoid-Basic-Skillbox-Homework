package com.skillbox.homework84

sealed class Result<out T, R> {

    data class Success<T, R>(
            val a: T
    ): Result<T, R>()

    data class Error<T, R>(
            val b: R
    ): Result<T, R>()

    object R1: Result<Int, String>()

    fun result(): R1 {

        val a = Success<Int, String>(34)
        val b = Error<Int, String>("generic")

        val r: R1

        return r
    }
}
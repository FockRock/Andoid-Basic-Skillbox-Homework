package com.skillbox.homework7

interface Warrior {
    val isKilled: Boolean
    val chanceBeingHit: Int

    fun attack(enemy: Warrior)

    fun takeDamage(damage: Int): Int
}
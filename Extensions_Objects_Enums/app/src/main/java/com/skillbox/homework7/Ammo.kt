package com.skillbox.homework7

import kotlin.random.Random

enum class Ammo(
        private val damage: Int,
        private val criticalHitRate: Int,
        private val criticalDamage: Int
) {
    PISTOL(1,15,5),
    SHELLS(5,23,7),
    GRENADE(10, 40, 10);
    

    fun takenDamage (damage: Int = this.damage,
                     criticalHitRate: Int = this.criticalHitRate,
                     criticalDamage: Int = this.criticalDamage): Int {
        return if (criticalHitRate.toBoolean()) damage*criticalDamage
        else damage
    }

    private fun Int.toBoolean(): Boolean {
        return this >= Random.nextInt(100)
    }
}
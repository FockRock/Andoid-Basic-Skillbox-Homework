package com.skillbox.homework7

import kotlin.random.Random

fun main() {
    println(Ammo.PISTOL.takenDamage())
    println(Ammo.SHELLS.takenDamage())
    println(Ammo.GRENADE.takenDamage())

    FireType.BurstFire(3)
}

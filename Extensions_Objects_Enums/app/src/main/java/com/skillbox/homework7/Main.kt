package com.skillbox.homework7

import kotlin.random.Random

fun main() {

    val soldier = Soldier(100,5,70, Weapons.createPistol())
    val captain = Captain(200,10,80, Weapons.createShotgun())
    val general = General(300,15, 90,Weapons.createGrenadeLauncher())

    general.attack(soldier)
    general.attack(soldier)
    general.attack(soldier)
    general.attack(soldier)
    general.attack(soldier)
}

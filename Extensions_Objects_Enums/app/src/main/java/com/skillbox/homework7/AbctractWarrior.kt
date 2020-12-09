package com.skillbox.homework7

import kotlin.random.Random

abstract class AbctractWarrior(
        maxHP: Int,
        override val chanceBeingHit: Int,
        private val accuracy: Int,
        private val weapon: AbstractWeapon,
        var hp: Int = maxHP
): Warrior {

    override fun attack(enemy: Warrior) {
        if (!weapon.ammoAvailability) {
            weapon.reload()
        } else for (i in weapon.ammoList) {
            weapon.getAmmo()
            if ((accuracy * Random.nextInt(100)) >= (enemy.chanceBeingHit * Random.nextInt(100))) {
                takeDamage(weapon.makeAmmo().takenDamage())
            }
        }
    }

    override fun takeDamage(damage: Int): Int {
        println("Was hit $damage damage!")
        return this.hp - damage
    }
}
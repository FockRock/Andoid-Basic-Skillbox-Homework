package com.skillbox.homework7

import kotlin.random.Random

abstract class AbstractWarrior(
        private val maxHP: Int,
        override val chanceBeingHit: Int,
        private val accuracy: Int,
        private val weapon: AbstractWeapon,
        var hp: Int = maxHP,
        override val isKilled: Boolean = false
): Warrior {

    override fun attack(enemy: Warrior) {
        if (!weapon.ammoAvailability) {
            println("Weapon reloaded.")
            weapon.reload()
        } else for (i in weapon.ammoList) {
            weapon.getAmmo()
            if ((accuracy * Random.nextInt(100)) >= (enemy.chanceBeingHit * Random.nextInt(100))) {
                takeDamage(weapon.makeAmmo().takenDamage())
                println("$enemy take ${takeDamage(weapon.makeAmmo().takenDamage())} damage!")
            }
        }
    }

    override fun takeDamage(damage: Int): Int {
        println("Was hit $damage damage!")
        return this.hp - damage
    }
}

class General(
        maxHP: Int,
        chanceBeingHit: Int,
        accuracy: Int,
        weapon: AbstractWeapon
): AbstractWarrior(maxHP, chanceBeingHit, accuracy,weapon) {
}

class Captain(
        maxHP: Int,
        chanceBeingHit: Int,
        accuracy: Int,
        weapon: AbstractWeapon
): AbstractWarrior(maxHP, chanceBeingHit, accuracy,weapon) {
}

class Soldier(
        maxHP: Int,
        chanceBeingHit: Int,
        accuracy: Int,
        weapon: AbstractWeapon
): AbstractWarrior(maxHP, chanceBeingHit, accuracy,weapon) {
}
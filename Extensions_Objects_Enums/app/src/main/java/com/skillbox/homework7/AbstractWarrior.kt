package com.skillbox.homework7

import kotlin.random.Random

abstract class AbstractWarrior(
        private val maxHP: Int,
        override val chanceBeingHit: Int,
        private val accuracy: Int,
        private val weapon: AbstractWeapon,
        var hp: Int = maxHP,
        override var isKilled: Boolean = false
): Warrior {


    override fun attack(enemy: Warrior) {
        if (weapon.ammoList.isEmpty()) {
            println("Weapon reloaded.")
            weapon.reload()
        } else {
            val ammoInGun = weapon.getAmmo()
            var totalDamage = 0
            for (each in ammoInGun) {
                if ((accuracy * Random.nextInt(100)) >= (enemy.chanceBeingHit * Random.nextInt(100)))
                    totalDamage += weapon.makeAmmo().takenDamage()
                    println("$totalDamage")
            }
            enemy.takeDamage(totalDamage)
        }
    }

    override fun takeDamage(damage: Int): Int {
        println("Was hit $damage damage!")
        println("He has ${this.hp - damage} HP!")
        this.hp -= damage
        if (this.hp <= 0) {
            isKilled = true
            println("Soldier was killed!")
        }
        return this.hp
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
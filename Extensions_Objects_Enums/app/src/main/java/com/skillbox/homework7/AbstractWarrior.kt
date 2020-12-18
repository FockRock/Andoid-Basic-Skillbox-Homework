package com.skillbox.homework7

import kotlin.random.Random

abstract class AbstractWarrior(
        private val maxHP: Int,
        override val chanceBeingHit: Int,
        private val accuracy: Int,
        private val weapon: AbstractWeapon,
        var hp: Int = maxHP,
        override var isKilled: Boolean = hp <= 0
): Warrior {


    override fun attack(enemy: Warrior) {
            if (!enemy.isKilled) {
                if (weapon.ammoList.isEmpty()) {
                    println("Weapon reloaded.")
                    weapon.reload()
                } else {
                    val ammoInGun = weapon.getAmmo()
                    var totalDamage = 0
                    for (each in ammoInGun) {
                        if ((accuracy * Random.nextInt(100)) >= (enemy.chanceBeingHit * Random.nextInt(100)))
                            totalDamage += weapon.makeAmmo().takenDamage()
                    }
                    enemy.takeDamage(totalDamage)
                }
            } else return
    }

    override fun takeDamage(damage: Int): Int {
        if (this.hp > 0) {
            println("Was hit $damage damage!")
            println("He has ${this.hp - damage} HP!")
            this.hp -= damage
        } else {
            isKilled = true
            println("Soldier was killed!")
            this.hp = 0
        }
        return this.hp
    }
}

class General(
        maxHP: Int = 300,
        chanceBeingHit: Int = 15,
        accuracy: Int = 90,
        weapon: AbstractWeapon = Weapons.createGrenadeLauncher()
): AbstractWarrior(maxHP, chanceBeingHit, accuracy,weapon,  isKilled = false) {
}

class Captain(
        maxHP: Int = 200,
        chanceBeingHit: Int = 10,
        accuracy: Int = 80,
        weapon: AbstractWeapon = Weapons.createShotgun()
): AbstractWarrior(maxHP, chanceBeingHit, accuracy,weapon, isKilled = false) {
}

class Soldier(
        maxHP: Int = 100,
        chanceBeingHit: Int = 5,
        accuracy: Int = 70,
        weapon: AbstractWeapon = Weapons.createPistol()
): AbstractWarrior(maxHP, chanceBeingHit, accuracy,weapon,  isKilled = false) {
}
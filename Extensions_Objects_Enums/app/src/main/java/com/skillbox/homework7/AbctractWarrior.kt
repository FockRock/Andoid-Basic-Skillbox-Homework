package com.skillbox.homework7

abstract class AbctractWarrior(
        maxHP: Int,
        override val chanceBeingHit: Int,
        val accuracy: Int,
        private val weapon: AbstractWeapon,
        var hp: Int = maxHP
): Warrior {

    override fun attack(enemy: Warrior) {
        if (!weapon.ammoAvailability) {
            weapon.reload()
        } else for (each in weapon.ammoList) {
            weapon.getAmmo()
            if (accuracy >= enemy.chanceBeingHit) {
                takeDamage(100)
            }
        }
    }

    override fun takeDamage(damage: Int): Int {
        println("Was hit $damage damage!")
        return this.hp - damage
    }
}
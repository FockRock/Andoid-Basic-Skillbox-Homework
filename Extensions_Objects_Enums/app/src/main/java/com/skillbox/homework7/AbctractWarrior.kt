package com.skillbox.homework7

abstract class AbctractWarrior(
        maxHP: Int,
        accuracy: Int,
        weapon: AbstractWeapon,
        override val chanceBeingHit: Int,
        var hp: Int = maxHP
): Warrior {

    override fun attack(enemy: Warrior) {
        TODO("Not yet implemented")
    }

    override fun takeDamage(damage: Int): Int {
        println("Was hit $damage damage!")
        return this.hp - damage
    }
}
package com.skillbox.homework7

abstract class AbctractWarrior(
        maxHP: Int,
        override val chanceBeingHit: Int,
        accuracy: Int,
        weapon: AbstractWeapon,
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
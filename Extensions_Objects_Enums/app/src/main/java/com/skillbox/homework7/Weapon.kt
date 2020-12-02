package com.skillbox.homework7

class Weapon (
        private val magazineSize: Int,
        override val fireType: FireType
        ): AbstractWeapon(
        magazineSize = this
        fireType = FireType.SingleShot
) {
    override fun makeAmmo(): Ammo {
        TODO("Not yet implemented")
    }
}
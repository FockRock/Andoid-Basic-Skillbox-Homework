package com.skillbox.homework7

abstract class AbstractWeapon (
        private val magazineSize: Int,
        val fireType: FireType
){
    private val ammoList =  arrayOf<Ammo>()
    val ammoAvailability: Boolean = ammoList.isNotEmpty()

    abstract fun makeAmmo(): Ammo

    fun reload() {
        val ammoList = arrayOf<Ammo>()
        for (each in ammoList) {
            makeAmmo()
        }
    }
}
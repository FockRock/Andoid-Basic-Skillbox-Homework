package com.skillbox.homework7

import java.util.ArrayList

abstract class AbstractWeapon (
        private val magazineSize: Int,
        open val fireType: FireType
){
    private val ammoList = arrayOf<Ammo>()
    val ammoAvailability: Boolean = ammoList.isNotEmpty()

    abstract fun makeAmmo(): Ammo

    fun reload() {
        val ammoList = this.ammoList
        var x = magazineSize
        for (each in ammoList) {
            makeAmmo()
            x--
        }
    }
}
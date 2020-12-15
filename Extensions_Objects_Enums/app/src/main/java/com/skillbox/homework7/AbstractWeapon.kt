package com.skillbox.homework7

abstract class AbstractWeapon (
        private val magazineSize: Int,
        open val fireType: FireType
){
    var ammoList = arrayListOf<Ammo>()
    var ammoAvailability: Boolean = ammoList.isNotEmpty()

    abstract fun makeAmmo(): Ammo

    fun reload(): ArrayList<Ammo> {
        for (i in 1..magazineSize) {
            ammoList.add(makeAmmo())
        }
        ammoAvailability = true
        return ammoList
    }

    fun getAmmo(): ArrayList<Ammo> {
        val ammoForShot = arrayListOf<Ammo>()
        if (this.ammoList.isNotEmpty()) {
        for (i in 1..fireType.queueLength)
            ammoForShot.add(makeAmmo())
        println("$ammoForShot in the gun!")
        this.ammoList.removeAll(ammoForShot)
        } else reload()
        return ammoForShot
    }
}

object Weapons {
    fun createPistol(): AbstractWeapon {
        return object : AbstractWeapon(8, FireType.SingleShot){
            override fun makeAmmo(): Ammo {
                return Ammo.BULLET
            }
        }
    }
    fun createUzi(): AbstractWeapon {
        return object : AbstractWeapon(30, FireType.BurstFire(5)){
            override fun makeAmmo(): Ammo {
                return Ammo.BULLET
            }
        }
    }
    fun createShotgun(): AbstractWeapon {
        return object : AbstractWeapon(12, FireType.SingleShot){
            override fun makeAmmo(): Ammo {
                return Ammo.SHELLS
            }
        }
    }
    fun createGrenadeLauncher(): AbstractWeapon {
        return object : AbstractWeapon(1, FireType.SingleShot){
            override fun makeAmmo(): Ammo {
                return Ammo.GRENADE
            }
        }
    }
}
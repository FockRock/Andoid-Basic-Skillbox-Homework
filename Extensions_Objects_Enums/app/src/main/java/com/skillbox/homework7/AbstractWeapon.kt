package com.skillbox.homework7

abstract class AbstractWeapon (
        private val magazineSize: Int,
        open val fireType: FireType
){
    val ammoList = arrayOf<Ammo>()
    val ammoAvailability: Boolean = ammoList.isNotEmpty()

    abstract fun makeAmmo(): Ammo

    fun reload(): ArrayList<Ammo> {
        val cartridge = arrayListOf<Ammo>()
        for (i in 0..magazineSize){
            cartridge.add(makeAmmo())
        }
        return cartridge
    }

    fun getAmmo(): List<Ammo> {
        return ammoList.drop(fireType.queueLength)
    }
}

object Weapons {
    fun createPistol(): AbstractWeapon {
        println("Pistol created.")
        return object : AbstractWeapon(8, FireType.SingleShot){
            override fun makeAmmo(): Ammo {
                return Ammo.BULLET
            }
        }
    }
    fun createUzi(): AbstractWeapon {
        println("Uzi created.")
        return object : AbstractWeapon(30, FireType.BurstFire(5)){
            override fun makeAmmo(): Ammo {
                return Ammo.BULLET
            }
        }
    }
    fun createShotgun(): AbstractWeapon {
        println("Shotgun created.")
        return object : AbstractWeapon(12, FireType.SingleShot){
            override fun makeAmmo(): Ammo {
                return Ammo.SHELLS
            }
        }
    }
    fun createGrenadeLauncher(): AbstractWeapon {
        println("Grenade Launcher created.")
        return object : AbstractWeapon(5, FireType.SingleShot){
            override fun makeAmmo(): Ammo {
                return Ammo.GRENADE
            }
        }
    }
}
package com.skillbox.homework7

sealed class FireType (val queueLength: Int) {
    object SingleShot: FireType(1)
    data class BurstFire(val size: Int): FireType(size)
}

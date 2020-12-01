package com.skillbox.homework7

sealed class FireType {
    object SingleShot: FireType()
    data class BurstFire(val size: Int): FireType()
}

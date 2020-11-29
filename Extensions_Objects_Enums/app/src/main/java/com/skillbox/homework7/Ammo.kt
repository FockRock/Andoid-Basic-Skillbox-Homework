package com.skillbox.homework7

enum class Ammo(
    damage: Int,
    criticalDamage: Int,
    criticalHitRate: Int
) {
    PISTOL(1,10,5),
    SHELLS(5,50,8),
    EXPLOSIVE(10, 100, 10);
}
package com.skillbox.homework7

sealed class BattleState{
    object Progress : BattleState()
    object Team1Win : BattleState()
    object Team2Win : BattleState()
    object Draw : BattleState()
}

package com.skillbox.homework7

class Battle(
        var team1: Team,
        var team2: Team,
        var result: Boolean
) {
    fun battleProgress(): BattleState {                                                             //Состояние битвы
        return if (team1.warriorList.isNotEmpty() || team2.warriorList.isNotEmpty())
            BattleState.Progress
        else if (team1.warriorList.isEmpty())
            BattleState.Team2Win
        else if (team2.warriorList.isEmpty())
            BattleState.Team1Win
        else BattleState.Draw
    }

}
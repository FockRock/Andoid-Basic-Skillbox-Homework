package com.skillbox.homework7

class Battle(
        var team1: Team,
        var team2: Team,
        var result: Boolean = false
) : Team(0){

    fun battleProgress(): BattleState {                                                             //Состояние битвы
        return if (team1.warriorList.isNotEmpty() || team2.warriorList.isNotEmpty()) {
            println("Бой продолжается")
            BattleState.Progress
        } else if (team1.warriorList.isEmpty()) {
            println("Команда 2 победила!")
            BattleState.Team2Win
        } else if (team2.warriorList.isEmpty()) {
            println("Команда 1 победила!")
            BattleState.Team1Win
        } else {
            println("Ничья")
            BattleState.Draw
        }
    }

    fun
}
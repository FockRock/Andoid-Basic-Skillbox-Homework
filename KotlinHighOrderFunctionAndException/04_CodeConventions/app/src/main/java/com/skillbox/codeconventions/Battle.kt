package com.skillbox.homework7

import kotlin.random.Random

class Battle(
    private var team1: Team,
    private var team2: Team,
    private var result: Boolean = false
) : Team(0) {

    private fun battleProgress(t1: Int, t2: Int): BattleState { // Состояние битвы
        val progress: BattleState

        if (t1 != 0 && t2 != 0) {
            println("Battle continue...")
            println(
                "Team 1 has $t1 soldier " +
                    "and Team 2 has $t2 soldier"
            )
            progress = BattleState.Progress
        } else if (t1 == 0) {
            println("Team 1 has no soldier!")
            println("Team 2 Win!")
            progress = BattleState.Team2Win
            result = true
        } else if (t2 == 0) {
            println("Team 2 has no soldier!")
            println("Team 1 Win!")
            progress = BattleState.Team1Win
            result = true
        } else {
            println("Draw")
            progress = BattleState.Draw
            result = true
        }
        return progress
    }

    fun battleIteration() { // Итерация битвы
        team1.getArmy()
        team2.getArmy()

        while (!result) {

            team1.warriorList.shuffle()
            team2.warriorList.shuffle()

            val team1Live = team1.warriorList.filter { !it.isKilled }
            val team2Live = team2.warriorList.filter { !it.isKilled }

            if (team1Live.isNotEmpty() && team2Live.isNotEmpty()) {
                for (i in team1Live) {
                    if (team2Live.size > 1 && team1Live.isNotEmpty()) {
                        println("$i attack!")
                        i.attack(team2Live[Random.nextInt(until = team2Live.size)])
                        battleProgress(team1Live.size, team2Live.size)
                    } else if (team2Live.size == 1) {
                        println("$i attack!")
                        i.attack(team2Live[0])
                        battleProgress(team1Live.size, team2Live.size)
                    }
                }
                for (i in team2Live) {
                    if (team1Live.size > 1 && team2Live.isNotEmpty()) {
                        println("$i attack!")
                        i.attack(team1Live[Random.nextInt(until = team1Live.size)])
                        battleProgress(team1Live.size, team2Live.size)
                    } else if (team1Live.size == 1) {
                        println("$i attack!")
                        i.attack(team1Live[0])
                        battleProgress(team1Live.size, team2Live.size)
                    }
                }
            } else {
                battleProgress(team1Live.size, team2Live.size)
            }
        }
    }
}

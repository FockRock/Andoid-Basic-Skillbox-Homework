package com.skillbox.homework7

import java.util.function.Predicate
import kotlin.random.Random

class Battle(
        var team1: Team,
        var team2: Team,
        var result: Boolean = false
) : Team(0){



    private fun battleProgress(t1: Int, t2: Int): BattleState {                                                             //Состояние битвы
        val progress: BattleState

        if (t1 != 0 || t2 != 0) {
            println("Battle continue...")
            println("Team 1 has $t1 soldier " +
                    "and Team 2 has $t2 soldier")
            progress = BattleState.Progress
        } else if (t1 == 0) {
            println("Team 2 Win!")
            progress = BattleState.Team2Win
            result = true
        } else if (t2 == 0) {
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

    fun battleIteration() {
        team1.getArmy()
        team2.getArmy()

        team1.warriorList.shuffle()
        team2.warriorList.shuffle()

        val team1Live = team1.warriorList.filter { !it.isKilled }
        val team2Live = team2.warriorList.filter { !it.isKilled }

        var a = 30

        while (a > 0) {
            for (i in team1Live) {
                i.attack(team2Live[Random.nextInt(0, until = team2Live.size)])
                }

            for (i in team2Live) {
                i.attack(team1Live[Random.nextInt(0, until = team1Live.size)])
            }
            println(team1Live)
            battleProgress(team1Live.size, team2Live.size)
            a--
        }
    }
}
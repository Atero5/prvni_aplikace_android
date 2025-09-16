package com.example.myapplication

import com.example.myapplication.Referee
import org.junit.Assert.*
import org.junit.Test

class RefereeTest {
    private val referee = Referee()

    companion object {
        private const val PLAYER_WINS = "Player wins!"
        private const val COMPUTER_WINS = "Computer wins!"
        private const val DRAW = "It's a draw!"


    }

    @Test
    fun testDraw() {
        assertEquals(DRAW, referee.determineWinner(Referee.Move.ROCK, Referee.Move.ROCK))
        assertEquals(DRAW, referee.determineWinner(Referee.Move.PAPER, Referee.Move.PAPER))
        assertEquals(DRAW, referee.determineWinner(Referee.Move.SCISSORS, Referee.Move.SCISSORS))
        assertEquals(DRAW, referee.determineWinner(Referee.Move.LIZARD, Referee.Move.LIZARD))
        assertEquals(DRAW, referee.determineWinner(Referee.Move.SPOCK, Referee.Move.SPOCK))
    }

    @Test
    fun playerWins() {
        assertEquals(PLAYER_WINS, referee.determineWinner(Referee.Move.ROCK, Referee.Move.SCISSORS))
        assertEquals(PLAYER_WINS, referee.determineWinner(Referee.Move.ROCK, Referee.Move.LIZARD))
        assertEquals(PLAYER_WINS, referee.determineWinner(Referee.Move.PAPER, Referee.Move.ROCK))
        assertEquals(PLAYER_WINS, referee.determineWinner(Referee.Move.PAPER, Referee.Move.SPOCK))
        assertEquals(PLAYER_WINS, referee.determineWinner(Referee.Move.SCISSORS, Referee.Move.PAPER))
        assertEquals(PLAYER_WINS, referee.determineWinner(Referee.Move.SCISSORS, Referee.Move.LIZARD))
        assertEquals(PLAYER_WINS, referee.determineWinner(Referee.Move.LIZARD, Referee.Move.PAPER))
        assertEquals(PLAYER_WINS, referee.determineWinner(Referee.Move.LIZARD, Referee.Move.SPOCK))
        assertEquals(PLAYER_WINS, referee.determineWinner(Referee.Move.SPOCK, Referee.Move.SCISSORS))
        assertEquals(PLAYER_WINS, referee.determineWinner(Referee.Move.SPOCK, Referee.Move.ROCK))
    }

    @Test
    fun computerWins() {
        assertEquals(COMPUTER_WINS, referee.determineWinner(Referee.Move.SCISSORS, Referee.Move.ROCK))
        assertEquals(COMPUTER_WINS, referee.determineWinner(Referee.Move.LIZARD, Referee.Move.ROCK))
        assertEquals(COMPUTER_WINS, referee.determineWinner(Referee.Move.ROCK, Referee.Move.PAPER))
        assertEquals(COMPUTER_WINS, referee.determineWinner(Referee.Move.SPOCK, Referee.Move.PAPER))
        assertEquals(COMPUTER_WINS, referee.determineWinner(Referee.Move.PAPER, Referee.Move.SCISSORS))
        assertEquals(COMPUTER_WINS, referee.determineWinner(Referee.Move.LIZARD, Referee.Move.SCISSORS))
        assertEquals(COMPUTER_WINS, referee.determineWinner(Referee.Move.PAPER, Referee.Move.LIZARD))
        assertEquals(COMPUTER_WINS, referee.determineWinner(Referee.Move.SPOCK, Referee.Move.LIZARD))
        assertEquals(COMPUTER_WINS, referee.determineWinner(Referee.Move.SCISSORS, Referee.Move.SPOCK))
        assertEquals(COMPUTER_WINS, referee.determineWinner(Referee.Move.ROCK, Referee.Move.SPOCK))
    }
}


package com.example.myapplication

class Referee {
    enum class Move {
        ROCK, PAPER, SCISSORS, LIZARD, SPOCK

    }

    companion object {
        private const val PLAYER_WINS = "Player wins!"
        private const val COMPUTER_WINS = "Computer wins!"
        private const val DRAW = "It's a draw!"
    }

    fun determineWinner(playerMove: Move, computerMove: Move): String {
        if (playerMove == computerMove) return DRAW

        return when {
                    (playerMove == Move.ROCK && computerMove == Move.SCISSORS) ||
                    (playerMove == Move.ROCK && computerMove == Move.LIZARD) ||
                    (playerMove == Move.PAPER && computerMove == Move.ROCK) ||
                    (playerMove == Move.PAPER && computerMove == Move.SPOCK) ||
                    (playerMove == Move.SCISSORS && computerMove == Move.PAPER) ||
                    (playerMove == Move.SCISSORS && computerMove == Move.LIZARD) ||
                    (playerMove == Move.LIZARD && computerMove == Move.PAPER) ||
                    (playerMove == Move.LIZARD && computerMove == Move.SPOCK) ||
                    (playerMove == Move.SPOCK && computerMove == Move.SCISSORS) ||
                    (playerMove == Move.SPOCK && computerMove == Move.ROCK) -> PLAYER_WINS
            else -> COMPUTER_WINS
        }
    }

    fun stringToMove(move: String): Move {
        return when (move.lowercase()) {
            "rock" -> Move.ROCK
            "paper" -> Move.PAPER
            "scissors" -> Move.SCISSORS
            "lizard" -> Move.LIZARD
            "spock" -> Move.SPOCK
            else -> throw IllegalArgumentException("Invalid move")
        }
    }

    fun displayResult(playerMove: Move, computerMove: Move): String {
        val result = determineWinner(playerMove, computerMove)
        return "Player chose: $playerMove\nComputer chose: $computerMove\n$result"
    }
}
package com.example.myapplication

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class Computer {

    private val _move = MutableStateFlow(Referee.Move.ROCK)
    val move: StateFlow<Referee.Move> = _move

    private var job: Job? = null

    fun startMoving() {
        job = CoroutineScope(Dispatchers.Default).launch {
            while (isActive) {
                _move.value = Referee.Move.values().random()
                delay(2000) // pokaždé jiný tah
            }
        }
    }

    fun stopMoving() {
        job?.cancel()
    }
}

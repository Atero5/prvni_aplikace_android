package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlinx.coroutines.flow.collectLatest

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                val referee = Referee()
                val computer = remember { Computer() }

                // spuštění počítače po načtení obrazovky
                LaunchedEffect(Unit) {
                    computer.startMoving()
                }

                // tah počítače jako State
                val computerMove by computer.move.collectAsState()

                var result by remember { mutableStateOf("") }

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text("Computer is choosing:")
                            MoveImage(move = computerMove)
                        }

                        Spacer(modifier = Modifier.height(24.dp))

                        // tlačítka pro hráče
                        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                            MoveButton(
                                move = Referee.Move.ROCK,
                                onClick = { playerMove ->
                                    result = referee.displayResult(playerMove, computerMove)
                                }
                            )
                            MoveButton(
                                move = Referee.Move.PAPER,
                                onClick = { playerMove ->
                                    result = referee.displayResult(playerMove, computerMove)
                                }
                            )
                            MoveButton(
                                move = Referee.Move.SCISSORS,
                                onClick = { playerMove ->
                                    result = referee.displayResult(playerMove, computerMove)
                                }
                            )
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                            MoveButton(
                                move = Referee.Move.SPOCK,
                                onClick = { playerMove ->
                                    result = referee.displayResult(playerMove, computerMove)
                                }
                            )
                            MoveButton(
                                move = Referee.Move.LIZARD,
                                onClick = { playerMove ->
                                    result = referee.displayResult(playerMove, computerMove)
                                }
                            )
                        }

                        Spacer(modifier = Modifier.height(24.dp))

                        if (result.isNotEmpty()) {
                            Text(text = result)
                        }
                    }
                }
            }
        }
    }
}
@Composable
fun MoveImage(move: Referee.Move, modifier: Modifier = Modifier) {
    val resId = when (move) {
        Referee.Move.ROCK -> R.drawable.rock
        Referee.Move.PAPER -> R.drawable.paper
        Referee.Move.SCISSORS -> R.drawable.scissors
        Referee.Move.SPOCK -> R.drawable.spock
        Referee.Move.LIZARD -> R.drawable.lizard
    }

    Image(
        painter = painterResource(id = resId),
        contentDescription = move.name,
        modifier = modifier.size(96.dp)
    )
}

@Composable
fun MoveButton(
    move: Referee.Move,
    onClick: (Referee.Move) -> Unit,
    modifier: Modifier = Modifier
) {
    val resId = when (move) {
        Referee.Move.ROCK -> R.drawable.rock
        Referee.Move.PAPER -> R.drawable.paper
        Referee.Move.SCISSORS -> R.drawable.scissors
        Referee.Move.SPOCK -> R.drawable.spock
        Referee.Move.LIZARD -> R.drawable.lizard
    }

    Button(onClick = { onClick(move) }) {
        Image(
            painter = painterResource(id = resId),
            contentDescription = move.name,
            modifier = modifier.size(64.dp)
        )
    }
}



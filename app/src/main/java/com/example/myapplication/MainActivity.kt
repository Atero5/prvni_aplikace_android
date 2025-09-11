package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
                        Text(text = "Computer is choosing: $computerMove")

                        Spacer(modifier = Modifier.height(24.dp))

                        // tlačítka pro hráče
                        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                            Button(onClick = {
                                val playerMove = referee.stringToMove("rock")
                                result = referee.displayResult(playerMove, computerMove)
                            }) {
                                Text("ROCK")
                            }

                            Button(onClick = {
                                val playerMove = referee.stringToMove("paper")
                                result = referee.displayResult(playerMove, computerMove)
                            }) {
                                Text("PAPER")
                            }

                            Button(onClick = {
                                val playerMove = referee.stringToMove("scissors")
                                result = referee.displayResult(playerMove, computerMove)
                            }) {
                                Text("SCISSORS")
                            }
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                            Button(onClick = {
                                val playerMove = referee.stringToMove("spock")
                                result = referee.displayResult(playerMove, computerMove)
                            }) {
                                Text("SPOCK")
                            }

                            Button(onClick = {
                                val playerMove = referee.stringToMove("lizard")
                                result = referee.displayResult(playerMove, computerMove)
                            }) {
                                Text("LIZARD")
                            }
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


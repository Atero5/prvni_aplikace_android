package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.ui.theme.Referee

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                val referee = Referee()

                // Stav pro výsledek
                var result by remember { mutableStateOf("") }

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        // Tlačítka pro tahy
                        Button(
                            onClick = {
                                val playerMove = referee.stringToMove("rock")
                                val computerMove = Referee.Move.values().random()
                                result = referee.displayResult(playerMove, computerMove)
                            }
                        ) {
                            Text(text = "ROCK")
                        }

                        Button(
                            onClick = {
                                val playerMove = referee.stringToMove("paper")
                                val computerMove = Referee.Move.values().random()
                                result = referee.displayResult(playerMove, computerMove)
                            }
                        ) {
                            Text(text = "PAPER")
                        }

                        Button(
                            onClick = {
                                val playerMove = referee.stringToMove("scissors")
                                val computerMove = Referee.Move.values().random()
                                result = referee.displayResult(playerMove, computerMove)
                            }
                        ) {
                            Text(text = "SCISSORS")
                        }

                        Button(
                            onClick = {
                                val playerMove = referee.stringToMove("lizard")
                                val computerMove = Referee.Move.values().random()
                                result = referee.displayResult(playerMove, computerMove)
                            }
                        ) {
                            Text(text = "LIZARD")
                        }

                        Button(
                            onClick = {
                                val playerMove = referee.stringToMove("spock")
                                val computerMove = Referee.Move.values().random()
                                result = referee.displayResult(playerMove, computerMove)
                            }
                        ) {
                            Text(text = "SPOCK")
                        }

                        // Výpis výsledku
                        if (result.isNotEmpty()) {
                            Text(
                                text = result,
                                modifier = Modifier.padding(start = 16.dp, top = 16.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

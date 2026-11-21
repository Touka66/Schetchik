package com.example.schetchik

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.schetchik.ui.theme.SchetchikTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SchetchikTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CounterTaskScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun CounterTaskScreen(modifier: Modifier = Modifier) {
    var count by remember {
        mutableIntStateOf(0)
    }


    val pinkButtonColor = Color(0xFFF48FB1)
    val greenCardColor = Color(0xFFDFF5E3)
    val greenTextColor = Color(0xFF1E7E34)

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterVertically)
    ) {
        Text(
            text = "Счётчик",
            fontSize = 24.sp
        )

        Text(
            text = "$count",
            fontSize = 40.sp
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = {
                    if (count > 0) {
                        count--
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = pinkButtonColor,
                    contentColor = Color.White
                )
            ) {
                Text("−1")
            }

            Button(
                onClick = {
                    if (count < 10) {
                        count++
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = pinkButtonColor,
                    contentColor = Color.White
                )
            ) {
                Text("+1")
            }
        }

        Button(
            onClick = {
                count = 0
            }
        ) {
            Text("Сбросить")
        }

        if (count == 10) {
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = greenCardColor
                )
            ) {
                Text(
                    text = "Максимум достигнут",
                    color = greenTextColor,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CounterPreview() {
    SchetchikTheme {
        CounterTaskScreen()
    }
}
package com.example.dheerajbioapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BioScreen()
        }
    }
}

@Composable
fun BioScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow)
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Dheeraj Ravidas",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Red
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Hello! My name is Dheeraj Ravidas.\n" +
                    "I am from Dhanbad, Jharkhand.\n" +
                    "I work at DishTV customer care.\n" +
                    "I am preparing for government exams (RRB Group D, SSC MTS).",
            fontSize = 18.sp
        )
    }
}

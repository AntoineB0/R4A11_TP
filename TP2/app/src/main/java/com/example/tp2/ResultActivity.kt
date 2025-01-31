package com.example.tp2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Calendar

class ResultActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val prenom = intent.getStringExtra("PRENOM") ?: "Inconnu"
        val anneeNaissance = intent.getStringExtra("ANNEE_NAISSANCE") ?: "0"

        
        val age = calculateAge(anneeNaissance.toIntOrNull() ?: 0)

        setContent {
            ResultScreen(prenom, age)
        }
    }

    private fun calculateAge(yearOfBirth: Int): Int {
        val currentYear = Calendar.getInstance().get(Calendar.YEAR)
        return currentYear - yearOfBirth
    }
}

@Composable
fun ResultScreen(prenom: String, age: Int) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Bonjour, $prenom !",
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = "Vous avez $age ans.",
            fontSize = 20.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )
    }
}

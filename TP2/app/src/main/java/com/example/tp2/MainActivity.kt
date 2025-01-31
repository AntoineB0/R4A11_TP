package com.example.tp2

import android.content.Intent
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


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WelcomeScreen { prenom, anneeNaissance ->

                val intent = Intent(this, ResultActivity::class.java).apply {
                    putExtra("PRENOM", prenom)
                    putExtra("ANNEE_NAISSANCE", anneeNaissance)
                }
                startActivity(intent) // Lancer la deuxième activité
            }
        }
    }
}

@Composable
fun WelcomeScreen(onValidate: (String, String) -> Unit) {
    var prenom by remember { mutableStateOf("") }
    var anneeNaissance by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Bienvenue !",
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )


        TextField(
            value = prenom,
            onValueChange = { prenom = it },
            label = { Text("Entrez votre prénom") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))


        TextField(
            value = anneeNaissance,
            onValueChange = { anneeNaissance = it },
            label = { Text("Entrez votre année de naissance") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))


        Button(
            onClick = {
                if (prenom.isNotEmpty() && anneeNaissance.isNotEmpty()) {
                    onValidate(prenom, anneeNaissance)
                }
            }
        ) {
            Text("Valider")
        }
    }
}

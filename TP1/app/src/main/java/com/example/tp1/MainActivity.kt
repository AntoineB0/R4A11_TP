package com.example.tp1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tp1.R.layout.activity_main2
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

const val EXTRA_TEXT = "message to display"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val premierBouton : Button = findViewById(R.id.button)
        val premiertextinput : TextInputLayout = findViewById(R.id.premiertextinput)
        val premiertextview : TextView = findViewById(R.id.textview)
        premierBouton.setOnClickListener {
            premiertextview.text = premiertextinput.editText?.text.toString()
        }

        val deuxiemeBouton : Button = findViewById(R.id.button2)
        deuxiemeBouton.setOnClickListener {
            intent.putExtra(EXTRA_TEXT, premiertextview.text.toString())
            val intent = Intent(this@MainActivity, MainActivity2::class.java)
            startActivity(intent)
        }


    }
}
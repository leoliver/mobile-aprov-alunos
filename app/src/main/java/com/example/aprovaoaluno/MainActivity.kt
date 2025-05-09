package com.example.aprovaoaluno

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val buttonNextTela = findViewById<Button>(R.id.buttonNext)

        buttonNextTela.setOnClickListener {
            val intent = Intent(
                this,
                AprovacaoAlunoActivity::class.java
            )
            startActivity(intent)
        }
    }
}
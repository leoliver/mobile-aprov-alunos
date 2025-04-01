package com.example.aprovaoaluno

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.graphics.Color
import androidx.appcompat.app.AppCompatDelegate

class AprovacaoAlunoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_aprovacao_aluno)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO) // Força o modo claro

        val editTextNota = findViewById<EditText>(R.id.notaAlunoInput)
        val buttonResultado = findViewById<Button>(R.id.buttonResultado)
        val textViewResultado = findViewById<TextView>(R.id.resultadoAluno)

        buttonResultado.setOnClickListener {

            val notaStr = editTextNota.text.toString()

            if (notaStr.isEmpty()) {
                Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show()
                textViewResultado.text = ""
                return@setOnClickListener
            }

            val nota = notaStr.toDoubleOrNull()

            if (nota == null || nota == 0.0 || nota > 10.0) {
                Toast.makeText(this, "Nota inválido. Verifique os números inseridos.", Toast.LENGTH_SHORT).show()
                textViewResultado.text = ""
            } else if (nota < 4){
                textViewResultado.text = "Nota: $nota. O aluno está reprovado!"
                textViewResultado.setTextColor(getColor(R.color.corReprovacao))
            } else if (nota >= 4 && nota < 6) {
                textViewResultado.text = "Nota: $nota. O aluno está de recuperação!"
                textViewResultado.setTextColor(getColor(R.color.corRecuperacao))
            } else {
                textViewResultado.text = "Nota: $nota. O aluno foi aprovado!"
                textViewResultado.setTextColor(getColor(R.color.corAprovacao))
            }

        }
    }
}
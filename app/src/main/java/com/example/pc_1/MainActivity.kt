package com.example.pc_1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

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
        val etParcial: EditText = findViewById(R.id.txtParcial)
        val etFinal: EditText = findViewById(R.id.txtFinal)
        val etPep: EditText = findViewById(R.id.txtPep)
        val btCalcular: Button = findViewById(R.id.btCalcular)

        btCalcular.setOnClickListener{
            this.sendMessage(etParcial.text.toString(),etFinal.text.toString(),etPep.text.toString())
        }
    }
    private fun sendMessage(Parcial: String,Final: String,Pep: String){
        val pesoParcial = 0.20
        val pesoFinal = 0.20
        val pesoPEP = 0.60

        val notFinal =   (Parcial.toDouble() * pesoParcial) + (Final.toDouble() * pesoFinal) + (Pep.toDouble() * pesoPEP)

        var resultado = ""
        if (notFinal > 10.5){
            resultado = "Aprobado"
        }else{
            resultado = "Desaprobado"
        }

        val intent = Intent(this, Resultado::class.java)
        intent.putExtra("notaFinal",notFinal.toString())
        intent.putExtra("resultado",resultado)
        startActivity(intent)
    }
}
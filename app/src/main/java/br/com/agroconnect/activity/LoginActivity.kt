package br.com.agroconnect.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import br.com.agroconnect.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val enter_button = findViewById<Button>(R.id.EnterButtonLogin)
        enter_button.setOnClickListener {
            val email_input = findViewById<EditText>(R.id.EmailInputLogin)
            val email = email_input.text.toString()
            val password_input = findViewById<EditText>(R.id.SenhaInputLogin)
            val password = password_input.text.toString()

            // Conta de Usuário (CPF)
            if (email == "usuario@email.com" && password == "123"){
                val intent = Intent(this, UserDashboard::class.java)
                startActivity(intent)
            }

            // Conta de Parceiro (CNPJ)
            if (email == "parceiro@email.com" && password == "123"){
                val intent = Intent(this, PartnerDashboard::class.java)
                startActivity(intent)
            }
        }
    }
}
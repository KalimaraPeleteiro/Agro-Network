package br.com.agroconnect.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import br.com.agroconnect.R

class PartnerOrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_partner_order)

        val intent = intent // Buscando o Intent usado no Adapter.

        val numberText = findViewById<TextView>(R.id.PartnerIndividualOrderNumber)
        numberText.text = "Pedido " + intent.getStringExtra("Number")

        val usernameText = findViewById<TextView>(R.id.PartnerIndividualOrderUsername)
        usernameText.text = "Produto: " + intent.getStringExtra("Username")

        val paymentText = findViewById<TextView>(R.id.PartnerIndividualOrderPaymentMethod)
        paymentText.text = "Método de Pagamento: " + intent.getStringExtra("Payment")

        val descriptionText = findViewById<TextView>(R.id.PartnerIndividualOrderDescription)
        descriptionText.text = intent.getStringExtra("Description")

        val proposal_button = findViewById<Button>(R.id.PartnerIndividualOrderButton)
        proposal_button.setOnClickListener {
            Toast.makeText(this, "O usuário será contatado.", Toast.LENGTH_LONG).show()
            finish()
        }
    }
}
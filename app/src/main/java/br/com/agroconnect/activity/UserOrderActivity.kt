package br.com.agroconnect.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import br.com.agroconnect.R

class UserOrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_order)

        val intent = intent // Buscando o Intent usado no Adapter.

        val numberText = findViewById<TextView>(R.id.IndividualUserOrderNumber)
        numberText.text = "Pedido " + intent.getStringExtra("Number")

        val productText = findViewById<TextView>(R.id.IndividualUserOrderProduct)
        productText.text = "Produto: " + intent.getStringExtra("Product")

        val paymentText = findViewById<TextView>(R.id.IndividualUserOrderPaymentMethod)
        paymentText.text = "Método de Pagamento: " + intent.getStringExtra("Payment")

        val statusText = findViewById<TextView>(R.id.IndividualUserOrderStatus)
        statusText.text = "Status: " + intent.getStringExtra("Status")

        val descriptionText = findViewById<TextView>(R.id.IndividualUserOrderDescription)
        descriptionText.text = intent.getStringExtra("Description")
    }
}
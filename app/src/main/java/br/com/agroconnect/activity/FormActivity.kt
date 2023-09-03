package br.com.agroconnect.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import br.com.agroconnect.R
import br.com.agroconnect.dao.UserOrderDAO
import br.com.agroconnect.model.UserOrder
import kotlin.random.Random

class FormActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        setContentView(R.layout.activity_form)

        val create_button = findViewById<Button>(R.id.FormInputCreateButton)
        create_button.setOnClickListener {
            val descriptionField = findViewById<EditText>(R.id.FormInputDescription)
            val descriptionText = descriptionField.text.toString()

            val nameField = findViewById<EditText>(R.id.FormInputNameOfProduct)
            val nameProduct = nameField.text.toString()

            val paymentField = findViewById<EditText>(R.id.FormInputPaymentMethod)
            val method = paymentField.text.toString()

            // Gerando um Número Aleatório para a Ordem.
            val number = (0..100000).random()

            val newOrder = UserOrder(
                orderNumber = number.toString(),
                status = "Pendente",
                description = descriptionText,
                product = nameProduct,
                paymentMethod = method
            )

            UserOrderDAO().add(newOrder)    // Adicionando na Lista de Ordens
            finish()
        }
    }
}
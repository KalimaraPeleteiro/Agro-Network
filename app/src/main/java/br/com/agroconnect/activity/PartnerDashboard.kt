package br.com.agroconnect.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.agroconnect.R
import br.com.agroconnect.adapter.PartnerOrderListAdapter
import br.com.agroconnect.adapter.UserOrderListAdapter
import br.com.agroconnect.model.PartnerOrder
import br.com.agroconnect.model.UserOrder

class PartnerDashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_partner_dashboard)

        val recyclerView = findViewById<RecyclerView>(R.id.PartnerOrderList)
        recyclerView.adapter = PartnerOrderListAdapter(context = this, orderList = listOf(
            PartnerOrder("24760", username = "João Mangabeira", paymentMethod = "PIX",
                         description = "Em busca de dezenas de caixas de mangas.", product = "Manga"),
            PartnerOrder("1290", username = "Maria das Luzes", paymentMethod = "Boleto",
                         description = "Preciso de maçãs frescas.", product = "Maçã")
        ))
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}
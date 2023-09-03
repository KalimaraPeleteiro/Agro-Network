package br.com.agroconnect.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.agroconnect.R
import br.com.agroconnect.adapter.UserOrderListAdapter
import br.com.agroconnect.dao.UserOrderDAO
import com.google.android.material.floatingactionbutton.FloatingActionButton

class UserDashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()

        setContentView(R.layout.activity_user_dashboard)

        val form_button = findViewById<FloatingActionButton>(R.id.NewOrderButton)
        form_button.setOnClickListener{
            val intent = Intent(this, FormActivity::class.java)
            startActivity(intent)
        }

        val recyclerView = findViewById<RecyclerView>(R.id.UserOrderList)
        val dao = UserOrderDAO()    // Criando a Lista de Pedidos pela Primeira vez.
        recyclerView.adapter = UserOrderListAdapter(context = this, orderList = dao.returnAll())
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}
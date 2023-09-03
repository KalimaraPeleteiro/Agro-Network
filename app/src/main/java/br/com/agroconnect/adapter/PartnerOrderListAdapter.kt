package br.com.agroconnect.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import br.com.agroconnect.R
import br.com.agroconnect.activity.PartnerOrderActivity
import br.com.agroconnect.model.PartnerOrder

class PartnerOrderListAdapter (
    private val context: Context,
    private val orderList: List<PartnerOrder>
) : RecyclerView.Adapter<PartnerOrderListAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun add(order: PartnerOrder) {
            val order_number = itemView.findViewById<TextView>(R.id.PartnerOrderNumber)
            order_number.text = "Pedido " + order.orderNumber
            val username = itemView.findViewById<TextView>(R.id.PartnerOrderUsername)
            username.text = "Usuário: " + order.username
            val product = itemView.findViewById<TextView>(R.id.PartnerOrderProduct)
            product.text = "Produto: " + order.product
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.partner_order, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = orderList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val order = orderList[position]
        holder.add(order)

        val layout_button = holder.itemView.findViewById<ConstraintLayout>(R.id.PartnerOrderClickableFrame)
        layout_button.setOnClickListener {
            val intent = Intent(context, PartnerOrderActivity::class.java)
            intent.putExtra("Number", order.orderNumber)
            intent.putExtra("Username", order.username)
            intent.putExtra("Payment", order.paymentMethod)
            intent.putExtra("Description", order.description)
            context.startActivity(intent)
        }
    }
}
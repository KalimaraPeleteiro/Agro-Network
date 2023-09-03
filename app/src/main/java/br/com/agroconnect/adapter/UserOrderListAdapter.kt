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
import br.com.agroconnect.activity.UserOrderActivity
import br.com.agroconnect.model.UserOrder

class UserOrderListAdapter (
    private val context: Context,
    private val orderList: List<UserOrder>
        ) : RecyclerView.Adapter<UserOrderListAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun add(order: UserOrder) {
            val order_number = itemView.findViewById<TextView>(R.id.UserOrderNumber)
            order_number.text = "Pedido " + order.orderNumber
            val status = itemView.findViewById<TextView>(R.id.UserOrderStatus)
            status.text = "Status: " + order.status
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.user_order, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = orderList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val order = orderList[position]
        holder.add(order)

        // Fazendo um botão para cada pedido.
        val layout_button = holder.itemView.findViewById<ConstraintLayout>(R.id.ClickableOrder)
        layout_button.setOnClickListener {
            val intent = Intent(context, UserOrderActivity::class.java)
            intent.putExtra("Number", order.orderNumber)
            intent.putExtra("Product", order.product)
            intent.putExtra("Payment", order.paymentMethod)
            intent.putExtra("Status", order.status)
            intent.putExtra("Description", order.description)
            context.startActivity(intent)
        }
    }

}

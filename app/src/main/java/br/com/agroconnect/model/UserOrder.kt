package br.com.agroconnect.model

class UserOrder(
    val orderNumber: String,
    val status: String,
    val description: String,
    val product: String,
    val paymentMethod: String
)
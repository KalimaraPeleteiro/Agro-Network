package br.com.agroconnect.dao

import br.com.agroconnect.model.UserOrder

class UserOrderDAO {

    fun add(newOrder: UserOrder){
        userOrdersList.add(newOrder)
    }

    fun returnAll(): List<UserOrder>{
        return userOrdersList.toList()
    }

    // Um pedido padrão para testes.
    companion object {
        private val userOrdersList = mutableListOf<UserOrder>(
            UserOrder("13778", "Pendente",
                      "Moro na cidade de São José das Graças, e estou pensando em abrir uma loja de bolos. \n" +
                                "\n" +
                                "Busco uma safra fresca de bananas, entre 5 e 10 dúzias, para a fabricação da primeira leva de bolos.\n" +
                                "\n" +
                                "Estou disposto a pagar mais caro por uma entrega mais rápida.",
                        "Banana", "PIX")
        )
    }
}
package br.com.newton.appmax.dao

import br.com.newton.appmax.model.request.Cliente
import br.com.newton.appmax.model.request.Pedido


class Repository {

    private val db by lazy { DaoInicializer.myDatabase() }

    fun insertCliente(cliente: Cliente) {
        db.clienteDao().insertClienteDao(cliente = cliente)
    }

    fun getCliente(): Cliente {
        return db.clienteDao().getClienteDao()
    }

    fun insertPedido(pedido: Pedido) {
        db.pedidoDao().insertPedidoDao(pedido)
    }

    fun getPedido(): List<Pedido> {
        return db.pedidoDao().getPedidoDao()
    }


}
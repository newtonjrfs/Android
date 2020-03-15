package br.com.newton.appmax.dao

import br.com.newton.appmax.model.dao.ClienteDao
import br.com.newton.appmax.model.dao.LegendaDao
import br.com.newton.appmax.model.dao.PedidoDao


class Repository {

    private val db by lazy { DaoInicializer.myDatabase() }

    fun insertCliente(clienteDao: ClienteDao) {
        db.clienteDatabaseDao().insertClienteDao(clienteDao = clienteDao)
    }

    fun getCliente(): ClienteDao? {
        return db.clienteDatabaseDao().getClienteDao()
    }

    fun insertPedido(pedido: List<PedidoDao>) {
        db.pedidoDatabaseDao().insertPedidoDao(pedido)
    }

    fun getPedido(): List<PedidoDao>? {
        return db.pedidoDatabaseDao().getPedidoDao()
    }

    fun insertLegenda(legendaDao: List<LegendaDao>) {
        db.LegendasDatabaseDao().insertLegendaDao(legendaDao = legendaDao)
    }

    fun getLegenda(): List<LegendaDao>? {
        return db.LegendasDatabaseDao().selectLegenda()
    }


}
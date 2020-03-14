package br.com.newton.appmax.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.newton.appmax.dao.entitys.ClienteDao
import br.com.newton.appmax.dao.entitys.PedidoDao
import br.com.newton.appmax.model.request.Cliente
import br.com.newton.appmax.model.request.Pedido

@Database(entities = [Cliente::class, Pedido::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun clienteDao(): ClienteDao
    abstract fun pedidoDao(): PedidoDao

}
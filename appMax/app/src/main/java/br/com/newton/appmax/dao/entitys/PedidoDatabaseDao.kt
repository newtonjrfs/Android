package br.com.newton.appmax.dao.entitys

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.newton.appmax.model.dao.PedidoDao


@Dao
interface PedidoDatabaseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPedidoDao(pedido: List<PedidoDao>)

    @Query("SELECT * FROM PedidoDao")
    fun getPedidoDao(): List<PedidoDao>?


}
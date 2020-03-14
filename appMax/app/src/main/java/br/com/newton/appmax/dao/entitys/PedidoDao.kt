package br.com.newton.appmax.dao.entitys

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.newton.appmax.model.request.Pedido


@Dao
interface PedidoDao {

    @Insert
    fun insertPedidoDao(pedido: Pedido)

    @Query("SELECT * FROM Pedido")
    fun getPedidoDao(): List<Pedido>


}
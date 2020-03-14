package br.com.newton.appmax.dao.entitys

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.newton.appmax.model.request.Cliente

@Dao
interface ClienteDao {

    @Insert
    fun insertClienteDao(cliente: Cliente)

    @Query("SELECT * FROM Cliente")
    fun getClienteDao(): Cliente


}
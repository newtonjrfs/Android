package br.com.newton.appmax.dao.entitys

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.newton.appmax.model.dao.ClienteDao

@Dao
interface ClienteDatabaseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertClienteDao(clienteDao: ClienteDao)

    @Query("SELECT * FROM ClienteDao")
    fun getClienteDao(): ClienteDao?


}
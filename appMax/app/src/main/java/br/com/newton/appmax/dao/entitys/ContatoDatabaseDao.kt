package br.com.newton.appmax.dao.entitys

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.newton.appmax.model.dao.ContatoDao

@Dao
interface ContatoDatabaseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertContatoDao(contatoDao: ContatoDao)

    @Query("SELECT * FROM ContatoDao")
    fun searchContato(): List<ContatoDao>
}
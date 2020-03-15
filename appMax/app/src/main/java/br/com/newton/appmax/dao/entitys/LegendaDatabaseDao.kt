package br.com.newton.appmax.dao.entitys

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.newton.appmax.model.dao.LegendaDao

@Dao
interface LegendaDatabaseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertLegendaDao(legendaDao: List<LegendaDao>)

    @Query("SELECT * From LegendaDao")
    fun selectLegenda(): List<LegendaDao>
}
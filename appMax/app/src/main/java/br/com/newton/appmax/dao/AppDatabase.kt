package br.com.newton.appmax.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.newton.appmax.dao.entitys.ClienteDatabaseDao
import br.com.newton.appmax.dao.entitys.ContatoDatabaseDao
import br.com.newton.appmax.dao.entitys.LegendaDatabaseDao
import br.com.newton.appmax.dao.entitys.PedidoDatabaseDao
import br.com.newton.appmax.model.dao.ClienteDao
import br.com.newton.appmax.model.dao.ContatoDao
import br.com.newton.appmax.model.dao.LegendaDao
import br.com.newton.appmax.model.dao.PedidoDao

@Database(
    entities = [ClienteDao::class, PedidoDao::class, ContatoDao::class, LegendaDao::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun clienteDatabaseDao(): ClienteDatabaseDao
    abstract fun pedidoDatabaseDao(): PedidoDatabaseDao
    abstract fun ContatoDatabaseDao(): ContatoDatabaseDao
    abstract fun LegendasDatabaseDao(): LegendaDatabaseDao

}
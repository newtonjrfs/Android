package br.com.newton.appmax.dao

import android.content.Context
import androidx.room.Room

class DaoInicializer {

    companion object {
        fun myDatabase(context: Context = App.getContext()!!): AppDatabase {

            val db = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "database"
                )
                .build()
            return db
        }
    }
}
package br.com.newton.appmax.dao

import androidx.room.TypeConverter

class Converters {
    @TypeConverter
    fun convertString(value: List<String>?): String? = value?.joinToString { "," }

    @TypeConverter
    fun convertList(status: String?): List<String>? = status?.split(",")
}

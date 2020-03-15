package br.com.newton.appmax.model.dao

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = arrayOf(
        ForeignKey(
            entity = PedidoDao::class,
            parentColumns = arrayOf("numero_ped_Rca"),
            childColumns = arrayOf("idPedido")
        )
    )
)
class LegendaDao(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val idPedido: Int,
    val description: String

)
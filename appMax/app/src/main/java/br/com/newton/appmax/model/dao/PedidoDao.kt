package br.com.newton.appmax.model.dao

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class PedidoDao(
    val NOMECLIENTE: String?, // Supermecado Giro Mais
    val codigoCliente: String?, // 965
    val critica: String?, // SUCESSO
    val `data`: String?, // 2018-09-12T08:33:18-0300
    @PrimaryKey(autoGenerate = false)
    val numero_ped_Rca: Int?, // 542189
    val numero_ped_erp: String?, // 6421800996
    val status: String?, // Processado
    val tipo: String? // PEDIDO
)
package br.com.newton.appmax.model.dao

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class ClienteDao(
    @PrimaryKey(autoGenerate = false)
    val id: Int?, // 30987
    val cnpj: String?, // 10.766.206/002-61
    val codigo: String?,// 40795A
    val endereco: String?, // Avenida 136 - Setor Sul - Goiânia/Goiás
    val nomeFantasia: String?, // Máxima Sistemas
    val ramo_atividade: String?, // Sistemas
    val razao_social: String?, // Máxima Sistemas S/A
    val status: String? // Indefinido
)
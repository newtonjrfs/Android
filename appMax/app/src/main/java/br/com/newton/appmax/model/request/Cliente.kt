package br.com.newton.appmax.model.request

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Cliente(
    val cnpj: String?, // 10.766.206/002-61
    val codigo: String?, // 40795A
    val contatos: List<Contato>?,
    val endereco: String?, // Avenida 136 - Setor Sul - Goiânia/Goiás
    @PrimaryKey(autoGenerate = false)
    val id: Int?, // 30987
    val nomeFantasia: String?, // Máxima Sistemas
    val ramo_atividade: String?, // Sistemas
    val razao_social: String?, // Máxima Sistemas S/A
    val status: String? // Indefinido
)
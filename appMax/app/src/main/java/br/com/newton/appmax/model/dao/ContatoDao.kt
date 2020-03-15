package br.com.newton.appmax.model.dao

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class ContatoDao(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val idCliente: Long,
    val celular: String?, // 62988889888
    val conjuge: String?,
    val dataNascimentoConjuge: String?, // null
    val data_nascimento: String?, // 1992-12-11
    val e_mail: String?, // gean.paiva@maximasistemas.com.br
    val nome: String?, // Gean Delon
    val telefone: String?, // 3333-3365
    val time: String?, // Flamengo
    val tipo: String? // Sócio
)
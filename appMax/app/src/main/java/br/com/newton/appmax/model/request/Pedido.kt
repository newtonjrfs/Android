package br.com.newton.appmax.model.request

data class Pedido(
    val NOMECLIENTE: String?, // Supermecado Giro Mais
    val codigoCliente: String?, // 965
    val critica: String?, // SUCESSO
    val `data`: String?, // 2018-09-12T08:33:18-0300
    val legendas: List<String>?,
    val numero_ped_Rca: Int?, // 542189
    val numero_ped_erp: String?, // 6421800996
    val status: String?, // Processado
    val tipo: String? // PEDIDO
)
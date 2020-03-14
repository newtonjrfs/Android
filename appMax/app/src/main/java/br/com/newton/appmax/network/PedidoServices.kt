package br.com.newton.appmax.network

import br.com.newton.appmax.model.request.ResponsePedidos
import retrofit2.Call
import retrofit2.http.GET

interface PedidoServices {
    @GET("wjl97")
    fun getRequest(): Call<ResponsePedidos>
}
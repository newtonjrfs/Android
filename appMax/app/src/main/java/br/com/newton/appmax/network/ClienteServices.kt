package br.com.newton.appmax.network

import br.com.newton.appmax.model.ResponseCliente
import retrofit2.Call
import retrofit2.http.GET

interface ClienteServices {

    @GET("1bo7qj")
    fun getClient(): Call<ResponseCliente>

}
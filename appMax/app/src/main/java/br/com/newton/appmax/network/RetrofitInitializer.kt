package br.com.newton.appmax.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {


    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.myjson.com/bins/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    //buscar cliente
    fun searchClient() = retrofit.create(ClienteServices::class.java)

    //buscar pedidos
    fun searchRequest() = retrofit.create(PedidoServices::class.java)


}
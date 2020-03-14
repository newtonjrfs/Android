package br.com.newton.appmax.network

import br.com.newton.appmax.model.request.ResponseCliente
import br.com.newton.appmax.model.request.ResponsePedidos
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Interector {

    fun searchCliente(callback: (ResponseCliente?) -> Unit) {
        val call = RetrofitInitializer().searchClient().getClient()
        call.enqueue(object : Callback<ResponseCliente?> {
            override fun onFailure(call: Call<ResponseCliente?>, t: Throwable) {
                callback.invoke(null)
            }

            override fun onResponse(
                call: Call<ResponseCliente?>,
                response: Response<ResponseCliente?>
            ) {
                response.body()?.let { result ->
                    callback.invoke(result)
                }
            }
        })
    }

    fun searchPedidos(callback: (ResponsePedidos?) -> Unit) {
        val call = RetrofitInitializer().searchRequest().getRequest()
        call.enqueue(object : Callback<ResponsePedidos?> {
            override fun onFailure(call: Call<ResponsePedidos?>, t: Throwable) {
                callback.invoke(null)
            }

            override fun onResponse(
                call: Call<ResponsePedidos?>,
                response: Response<ResponsePedidos?>
            ) {
                response.body()?.let { result ->
                    callback.invoke(result)
                }
            }

        })
    }

}
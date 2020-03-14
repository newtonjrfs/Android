package br.com.newton.appmax.presenter

import br.com.newton.appmax.model.view.Pedidos
import br.com.newton.appmax.network.Interector
import br.com.newton.appmax.task.PedidosInterface

class PedidosPresenter(val view: PedidosInterface.ViewPedidosInterface) :
    PedidosInterface.PresenterPedidosInterface {

    val interector by lazy { Interector() }

    override fun searchPedidos() {
        interector.searchPedidos { result ->

            if (result == null) {
                //buscar dados no banco
            } else {
                val pedidos = result.pedidos
                pedidos?.let {
                    val list = ArrayList<Pedidos>()
                    list.clear()
                    for (i in pedidos.indices) {
                        list.add(
                            Pedidos(
                                pedido = "${pedidos[i]!!.numero_ped_Rca} / ${pedidos[i]!!.numero_ped_erp}",
                                cliente = "${pedidos[i]!!.codigoCliente}-${pedidos[i]!!.NOMECLIENTE}",
                                status = pedidos[i]!!.status,
                                legendas = pedidos[i]!!.legendas,
                                horarios = pedidos[i]!!.data,
                                valor = "R$ 0,00",
                                critica = pedidos[i]!!.critica,
                                tipo = pedidos[i]!!.tipo
                            )
                        )
                    }
                    view.showPedidos(list)
                }
            }


        }
    }


}
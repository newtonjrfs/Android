package br.com.newton.appmax.presenter

import br.com.newton.appmax.dao.Repository
import br.com.newton.appmax.general.MyCoroutines
import br.com.newton.appmax.model.dao.LegendaDao
import br.com.newton.appmax.model.dao.PedidoDao
import br.com.newton.appmax.model.view.Pedidos
import br.com.newton.appmax.network.Interector
import br.com.newton.appmax.task.PedidosInterface
import kotlinx.coroutines.launch

class PedidosPresenter(val view: PedidosInterface.ViewPedidosInterface) :
    PedidosInterface.PresenterPedidosInterface, MyCoroutines() {

    val interector by lazy { Interector() }
    val repository by lazy { Repository() }

    override fun searchPedidos() {

        launch(io()) {
            val listPedidos = repository.getPedido()
            if (listPedidos.isNullOrEmpty()) {
                interector.searchPedidos { result ->

                    if (result != null) {
                        val pedidos = result.pedidos
                        pedidos?.let { listaPedido ->
                            val arrayListPedido = ArrayList<PedidoDao>()
                            arrayListPedido.clear()

                            val arrayListLegendas = ArrayList<LegendaDao>()
                            arrayListLegendas.clear()


                            for (i in listaPedido.indices) {

                                listaPedido[i].legendas?.let {
                                    for (a in it.indices) {
                                        arrayListLegendas.add(
                                            LegendaDao(
                                                id = 0,
                                                idPedido = listaPedido[i].numero_ped_Rca!!,
                                                description = it[a]
                                            )
                                        )
                                    }
                                }

                                arrayListPedido.add(
                                    PedidoDao(
                                        NOMECLIENTE = listaPedido[i].NOMECLIENTE,
                                        codigoCliente = listaPedido[i].codigoCliente,
                                        critica = listaPedido[i].critica,
                                        data = listaPedido[i].data,
                                        numero_ped_Rca = listaPedido[i].numero_ped_Rca,
                                        numero_ped_erp = listaPedido[i].numero_ped_erp,
                                        status = listaPedido[i].status,
                                        tipo = listaPedido[i].tipo
                                    )

                                )
                            }
                            launch(io()) { repository.insertPedido(pedido = arrayListPedido) }
                            launch(io()) { repository.insertLegenda(legendaDao = arrayListLegendas) }
                            launch(main()) { convertPedidos(arrayListPedido, arrayListLegendas) }
                        }
                    } else {
                        launch(main()) { view.alertNotPedidos() }
                    }
                }
            } else {
                launch(io()) {
                    val listLegenda = repository.getLegenda()
                    launch(main()) { convertPedidos(listPedidos, listLegenda) }
                }

            }
        }


    }

    private fun convertPedidos(listaPedido: List<PedidoDao>, listaLegendas: List<LegendaDao>?) {
        val list = ArrayList<Pedidos>()
        list.clear()
        for (i in listaPedido.indices) {
            var legenda = ""

            for (a in listaLegendas!!.indices) {
                if (listaLegendas[a].idPedido == listaPedido[i].numero_ped_Rca) {
                    if (legenda == "") {
                        legenda = listaLegendas[a].description
                    }
                }
            }

            list.add(
                Pedidos(
                    pedido = "${listaPedido[i].numero_ped_Rca} / ${listaPedido[i].numero_ped_erp}",
                    cliente = "${listaPedido[i].codigoCliente}-${listaPedido[i].NOMECLIENTE}",
                    status = listaPedido[i].status,
                    legendas = legenda,
                    horarios = listaPedido[i].data,
                    valor = "R$ 0,00",
                    critica = listaPedido[i].critica,
                    tipo = listaPedido[i].tipo
                )
            )
        }
        view.showPedidos(list)

    }


}
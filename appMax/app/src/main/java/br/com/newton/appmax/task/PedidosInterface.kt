package br.com.newton.appmax.task

import br.com.newton.appmax.model.view.Pedidos
import java.util.*

interface PedidosInterface {

    interface PresenterPedidosInterface {
        fun searchPedidos()

    }

    interface ViewPedidosInterface {
        fun showPedidos(list: ArrayList<Pedidos>)

    }

}
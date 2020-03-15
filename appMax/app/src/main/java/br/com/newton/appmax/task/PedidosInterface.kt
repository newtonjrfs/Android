package br.com.newton.appmax.task

import br.com.newton.appmax.model.view.PedidosView

interface PedidosInterface {

    interface PresenterPedidosInterface {
        fun searchPedidos()

    }

    interface ViewPedidosInterface {
        fun showPedidos(list: List<PedidosView>)
        fun alertNotPedidos()

    }

}
package br.com.newton.appmax.task

import br.com.newton.appmax.model.view.ClienteView
import br.com.newton.appmax.model.view.ContatosView
import java.util.*

interface DadosInterface {

    interface PresenterDadosInterface {
        fun searchCliente()
    }

    interface ViewDadosInterface {
        fun showCliente(cliente: ClienteView)
        fun showContatos(list: ArrayList<ContatosView>)
        fun showStatus(status: String?)
        fun alertNotCliente()

    }

}
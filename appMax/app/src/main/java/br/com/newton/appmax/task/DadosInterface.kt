package br.com.newton.appmax.task

import br.com.newton.appmax.model.request.Cliente
import br.com.newton.appmax.model.view.Contatos
import java.util.*

interface DadosInterface {

    interface PresenterDadosInterface {
        fun searchCliente()
    }

    interface ViewDadosInterface {
        fun showCliente(cliente: Cliente)
        fun showContatos(list: ArrayList<Contatos>)
        fun showStatus(status: String?)

    }

}
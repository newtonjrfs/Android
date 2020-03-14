package br.com.newton.appmax.presenter

import br.com.newton.appmax.dao.Repository
import br.com.newton.appmax.model.view.Contatos
import br.com.newton.appmax.network.Interector
import br.com.newton.appmax.task.DadosInterface
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class DadosPresenter(val view: DadosInterface.ViewDadosInterface) :
    DadosInterface.PresenterDadosInterface {

    val interector by lazy { Interector() }
    val repository by lazy { Repository() }

    override fun searchCliente() {
        interector.searchCliente { result ->
            if (result == null) {
                //buscar no banco de dados
            } else {
                val cliente = result.cliente
                cliente?.let {
                    view.showCliente(it)

                    view.showStatus(it.status)

                    val list = ArrayList<Contatos>()
                    list.clear()

                    val contato = it.contatos
                    contato?.let { contatos ->
                        for (i in contatos.indices) {

                            val dataNascContato =
                                if (!contatos[i].data_nascimento.isNullOrEmpty()) {
                                    val date = SimpleDateFormat(
                                        "yyyy-MM-dd",
                                        Locale.ROOT
                                    ).parse(contatos[i].data_nascimento!!)
                                    SimpleDateFormat("dd/MM/yyyy", Locale.ROOT).format(date)
                                } else {
                                    contatos[i].data_nascimento
                                }

                            val dataNascConj =
                                if (!contatos[i].dataNascimentoConjuge.isNullOrEmpty()) {
                                    val date = SimpleDateFormat(
                                        "yyyy-MM-dd",
                                        Locale.ROOT
                                    ).parse(contatos[i].dataNascimentoConjuge!!)
                                    SimpleDateFormat("dd/MM/yyyy", Locale.ROOT).format(date)
                                } else {
                                    contatos[i].dataNascimentoConjuge
                                }

                            list.add(
                                Contatos(
                                    nome = contatos[i].nome,
                                    telefone = contatos[i].telefone,
                                    celular = contatos[i].celular,
                                    conjuge = contatos[i].conjuge,
                                    tipo = contatos[i].tipo,
                                    email = contatos[i].e_mail,
                                    dataNascimento = dataNascContato,
                                    dataNascimentoConjuge = dataNascConj,
                                    time = contatos[i].time
                                )
                            )
                        }
                    }
                    view.showContatos(list)
                }
            }
        }
    }


}
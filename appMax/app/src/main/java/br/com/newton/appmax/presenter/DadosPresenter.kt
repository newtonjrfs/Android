package br.com.newton.appmax.presenter

import br.com.newton.appmax.model.view.Contatos
import br.com.newton.appmax.network.Interector
import br.com.newton.appmax.task.DadosInterface

class DadosPresenter(val view: DadosInterface.ViewDadosInterface) :
    DadosInterface.PresenterDadosInterface {

    val interector by lazy { Interector() }

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

                    contato.let { contatos ->
                        for (i in contatos!!.indices) {

                            val nomeContato =
                                if (contatos[i]!!.nome != null && contatos[i]!!.nome!!.isNotEmpty()) {
                                    contatos[i]!!.nome
                                } else {
                                    "Não informado"
                                }
                            val telefoneContato =
                                if (contatos[i]!!.telefone != null && contatos[i]!!.telefone!!.isNotEmpty()) {
                                    contatos[i]!!.telefone
                                } else {
                                    "Não informado"
                                    //getString(R.string.nao_informado)
                                }
                            val celularContato =
                                if (contatos[i]!!.celular != null && contatos[i]!!.celular!!.isNotEmpty()) {
                                    contatos[i]!!.celular
                                } else {
                                    "Não informado"
                                    //getString(R.string.nao_informado)
                                }
                            val conjugeContato =
                                if (contatos[i]!!.conjuge != null && contatos[i]!!.conjuge!!.isNotEmpty()) {
                                    contatos[i]!!.conjuge
                                } else {
                                    "Não informado"
                                    //getString(R.string.nao_informado)
                                }
                            val tipoContato =
                                if (contatos[i]!!.tipo != null && contatos[i]!!.tipo!!.isNotEmpty()) {
                                    contatos[i]!!.tipo
                                } else {
                                    "Não informado"
                                    //getString(R.string.nao_informado)
                                }
                            val emailContato =
                                if (contatos[i]!!.e_mail != null && contatos[i]!!.e_mail!!.isNotEmpty()) {
                                    contatos[i]!!.e_mail
                                } else {
                                    "Não informado"
                                    //getString(R.string.nao_informado)
                                }
                            val dataNascContato =
                                if (contatos[i]!!.data_nascimento != null && contatos[i]!!.data_nascimento!!.isNotEmpty()) {
                                    "${contatos[i]!!.data_nascimento!!.split("-")[2]}/" +
                                            "${contatos[i]!!.data_nascimento!!.split("-")[1]}/" +
                                            contatos[i]!!.data_nascimento!!.split("-")[0]
                                } else {
                                    "Não informado"
                                    //getString(R.string.nao_informado)
                                }
                            val dataNascConj =
                                if (contatos[i]!!.dataNascimentoConjuge != null && contatos[i]!!.dataNascimentoConjuge!!.isNotEmpty()) {
                                    "${contatos[i]!!.dataNascimentoConjuge!!.split("-")[2]}/" +
                                            "${contatos[i]!!.dataNascimentoConjuge!!.split("-")[1]}/" +
                                            contatos[i]!!.dataNascimentoConjuge!!.split("-")[0]
                                } else {
                                    "Não informado"
                                    //getString(R.string.nao_informado)
                                }
                            val timeContato =
                                if (contatos[i]!!.time != null && contatos[i]!!.time!!.isNotEmpty()) {
                                    contatos[i]!!.time
                                } else {
                                    "Não informado"
                                    //getString(R.string.nao_informado)
                                }

                            list.add(
                                Contatos(
                                    nome = nomeContato,
                                    telefone = telefoneContato,
                                    celular = celularContato,
                                    conjuge = conjugeContato,
                                    tipo = tipoContato,
                                    email = emailContato,
                                    dataNascimento = dataNascContato,
                                    dataNascimentoConjuge = dataNascConj,
                                    time = timeContato
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
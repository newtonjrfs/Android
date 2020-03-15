package br.com.newton.appmax.presenter

import br.com.newton.appmax.dao.Repository
import br.com.newton.appmax.general.MyCoroutines
import br.com.newton.appmax.model.dao.ClienteDao
import br.com.newton.appmax.model.dao.ContatoDao
import br.com.newton.appmax.model.view.ClienteView
import br.com.newton.appmax.model.view.ContatosView
import br.com.newton.appmax.network.Interector
import br.com.newton.appmax.task.DadosInterface
import kotlinx.coroutines.launch

class DadosPresenter(val view: DadosInterface.ViewDadosInterface) :
    DadosInterface.PresenterDadosInterface, MyCoroutines() {

    val interector by lazy { Interector() }
    val repository by lazy { Repository() }

    override fun searchCliente() {

        launch(io()) {
            val clientes = repository.getCliente()

            if (clientes == null) {

                interector.searchCliente { result ->

                    if (result != null) {
                        val cliente = result.cliente

                        cliente?.let {
                            val clienteDao = ClienteDao(
                                id = it.id,
                                cnpj = it.cnpj,
                                codigo = it.codigo,
                                endereco = it.endereco,
                                nomeFantasia = it.nomeFantasia,
                                ramo_atividade = it.ramo_atividade,
                                razao_social = it.razao_social,
                                status = it.status
                            )
                            launch(io()) {
                                repository.insertCliente(clienteDao)
                            }

                            convertClienteDao(clienteDao)

                            cliente.contatos?.let { listContato ->
                                val contatoDao = ArrayList<ContatoDao>()
                                contatoDao.clear()
                                for (a in listContato.indices) {
                                    contatoDao.add(
                                        ContatoDao(
                                            id = 0,
                                            idCliente = cliente.id!!,
                                            celular = listContato[a].celular,
                                            conjuge = listContato[a].conjuge,
                                            dataNascimentoConjuge = listContato[a].dataNascimentoConjuge,
                                            data_nascimento = listContato[a].data_nascimento,
                                            e_mail = listContato[a].e_mail,
                                            nome = listContato[a].nome,
                                            telefone = listContato[a].telefone,
                                            time = listContato[a].time,
                                            tipo = listContato[a].tipo
                                        )
                                    )
                                }
                                launch(io()) { repository.insertContato(contatoDao) }
                                convertContatosDao(contatoDao)
                            }

                        }
                    } else {
                        launch(main()) {
                            view.alertNotCliente()
                        }
                    }
                }
            } else {
                convertClienteDao(clientes)
                launch(main()) { view.showStatus(clientes.status) }
                launch(io()) {
                    val listContatoDao = repository.getContato()
                    listContatoDao?.let {
                        convertContatosDao(it)
                    }
                }
            }
        }
    }

    private fun convertContatosDao(contatoDao: List<ContatoDao>) {

        val listContatoView = ArrayList<ContatosView>()

        for (i in contatoDao.indices) {
            listContatoView.add(
                ContatosView(
                    nome = contatoDao[i].nome,
                    telefone = contatoDao[i].telefone,
                    celular = contatoDao[i].celular,
                    conjuge = contatoDao[i].conjuge,
                    tipo = contatoDao[i].tipo,
                    email = contatoDao[i].e_mail,
                    dataNascimento = contatoDao[i].data_nascimento,
                    dataNascimentoConjuge = contatoDao[i].dataNascimentoConjuge,
                    time = contatoDao[i].time
                )
            )
        }

        launch(main()) { view.showContatos(listContatoView) }

    }

    private fun convertClienteDao(clienteDao: ClienteDao) {
        val cliente = ClienteView(
            nome = "${clienteDao.codigo} - ${clienteDao.razao_social}",
            nomeFantasia = clienteDao.nomeFantasia,
            cnpj = clienteDao.cnpj,
            ramo = clienteDao.ramo_atividade,
            endereco = clienteDao.endereco
        )
        launch(main()) { view.showCliente(cliente) }
    }
}
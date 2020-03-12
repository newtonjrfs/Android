package br.com.newton.appmax.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.newton.appmax.R
import br.com.newton.appmax.model.Contatos
import br.com.newton.appmax.view.adapters.DadosAdapter

/**
 * A simple [Fragment] subclass.
 */
class DadosFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        activity!!.setTitle(R.string.dados_do_cliente)
        return inflater.inflate(R.layout.fragment_dados, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = ArrayList<Contatos>()
        list.add(
            Contatos(
                telefone = "3333-3365",
                nome = "Gean Delon",
                celular = "62988889888",
                conjuge = "Não Informado",
                tipo = "Sócio",
                email = "gean.paiva@maximasist.com.br",
                dataNascimento = "11/12/1992",
                dataNascimentoConjuge = "Não Informado",
                time = "Flamengo"
            )
        )

        populateContacts(list)

    }

    private fun populateContacts(list: java.util.ArrayList<Contatos>) {

        activity?.let { activityFragment ->
            val recyclerView =
                activityFragment.findViewById<RecyclerView>(R.id.recyclerViewListaContatos)
            recyclerView.layoutManager =
                LinearLayoutManager(
                    context,
                    RecyclerView.VERTICAL,
                    false

                )
            val adapter = DadosAdapter(list)
            recyclerView.adapter = adapter
        }


    }

}

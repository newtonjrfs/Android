package br.com.newton.appmax.view.fragment

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.newton.appmax.R
import br.com.newton.appmax.model.request.Cliente
import br.com.newton.appmax.model.view.Contatos
import br.com.newton.appmax.presenter.DadosPresenter
import br.com.newton.appmax.task.DadosInterface
import br.com.newton.appmax.view.adapters.DadosAdapter
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_dados.*
import java.text.SimpleDateFormat
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class DadosFragment : Fragment(), DadosInterface.ViewDadosInterface {

    val presenter by lazy { DadosPresenter(this) }

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

        presenter.searchCliente()
    }

    override fun showCliente(cliente: Cliente) {
        textViewRazaoSocial.text = "${cliente.codigo} - ${cliente.razao_social}"
        textViewNomeFantasia.text = "${cliente.nomeFantasia}"
        textViewCpf.text = ""
        textViewCnpj.text = "${cliente.cnpj}"
        textViewRamo.text = "${cliente.ramo_atividade}"
        textViewEndereco.text = "${cliente.endereco}"


    }

    override fun showContatos(list: java.util.ArrayList<Contatos>) {
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

    override fun showStatus(status: String?) {
        buttonVerifyStatus.setOnClickListener {
            val date = SimpleDateFormat("dd/MM/yyyy hh:mm", Locale.ROOT).format(Date())
            Snackbar.make(
                    activity!!.findViewById(R.id.fragmentCliente),
                    "$date - $status",
                    8000
                )
                /*tentei subir o snack mas nao deu certo
                .apply {
                    view.layoutParams = (view.layoutParams as FrameLayout.LayoutParams)
                        .apply {setMargins(0, 0, 0, resources.getDimension(R.dimen.bottom_height).toInt())}
                }*/
                .setAction("FECHAR") {}
                .setActionTextColor(Color.parseColor("#638735"))
                .show()
        }
    }
}

package br.com.newton.appmax.view.fragment

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.newton.appmax.R
import br.com.newton.appmax.model.view.ClienteView
import br.com.newton.appmax.model.view.ContatosView
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
        return inflater.inflate(R.layout.fragment_dados, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.searchCliente()

        toolbarDados.setNavigationOnClickListener { activity!!.finish() }
    }

    override fun showCliente(cliente: ClienteView) {
        textViewRazaoSocial.text = cliente.nome ?: ""
        textViewNomeFantasia.text = cliente.nomeFantasia ?: ""
        textViewCnpj.text = cliente.cnpj ?: ""
        textViewRamo.text = cliente.ramo ?: ""
        textViewEndereco.text = cliente.endereco ?: ""


    }

    override fun showContatos(list: ArrayList<ContatosView>) {
        activity?.let { activityFragment ->
            val recyclerView =
                activityFragment.findViewById<RecyclerView>(R.id.recyclerViewListaContatos)
            recyclerView.layoutManager =
                LinearLayoutManager(
                    context,
                    RecyclerView.VERTICAL,
                    false

                )
            val adapter = DadosAdapter(list, getString(R.string.nao_informado))
            recyclerView.adapter = adapter
        }
        progressBarDados.visibility = View.GONE

    }

    override fun showStatus(status: String?) {
        buttonVerifyStatus.setOnClickListener {
            val date = SimpleDateFormat("dd/MM/yyyy hh:mm", Locale.ROOT).format(Date())
            snackToast("$date - $status")
        }
    }

    override fun alertNotCliente() {
        snackToast(getString(R.string.nao_foi_possivel_carregar))
    }

    private fun snackToast(text: String) {
        Snackbar.make(
                activity!!.findViewById(R.id.coordinator),
                text,
                8000
            )
            .apply {
                view.layoutParams = (view.layoutParams as CoordinatorLayout.LayoutParams)
                    .apply {
                        this.anchorId = R.id.bottomNavigationViewCliente
                        this.anchorGravity = Gravity.TOP
                        this.gravity = Gravity.TOP
                    }
            }
            .setAction("FECHAR") {}
            .setActionTextColor(Color.parseColor("#638735"))
            .show()
    }
}

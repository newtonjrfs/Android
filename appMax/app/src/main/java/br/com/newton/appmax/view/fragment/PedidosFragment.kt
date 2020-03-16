package br.com.newton.appmax.view.fragment

import android.app.AlertDialog
import android.graphics.Color
import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.newton.appmax.R
import br.com.newton.appmax.model.view.PedidosView
import br.com.newton.appmax.presenter.PedidosPresenter
import br.com.newton.appmax.task.PedidosInterface
import br.com.newton.appmax.view.adapters.PedidosAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_pedidos.*


/**
 * A simple [Fragment] subclass.
 */
class PedidosFragment : Fragment(), PedidosInterface.ViewPedidosInterface {

    private val presenter by lazy { PedidosPresenter(this) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pedidos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val nav = activity!!.findViewById<BottomNavigationView>(R.id.bottomNavigationViewCliente)
        nav.selectedItemId = R.id.historico

        toolbarPedidos.setNavigationOnClickListener {
            activity!!.supportFragmentManager.popBackStackImmediate()
        }

        toolbarPedidos.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.item_legendas -> alertDialogLegendas()
            }
            true
        }

    }

    override fun onResume() {
        super.onResume()
        presenter.searchPedidos()
    }

    override fun showPedidos(list: List<PedidosView>) {

        activity?.let { activityFragment ->
            val recyclerView =
                activityFragment.findViewById<RecyclerView>(R.id.recyclerViewPedidos)
            recyclerView.layoutManager =
                LinearLayoutManager(
                    context,
                    RecyclerView.VERTICAL,
                    false
                )
            val adapter = PedidosAdapter(list)
            recyclerView.adapter = adapter
        }

        progressBarPedidos?.let {
            progressBarPedidos.visibility = View.GONE
        }

    }

    override fun alertNotPedidos() {
        Snackbar.make(
                activity!!.findViewById(R.id.coordinator),
                getString(R.string.nao_foi_possivel_carregar),
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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        MenuInflater(context).inflate(R.menu.menu_legendas, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    private fun alertDialogLegendas() {
        val builder = AlertDialog.Builder(context)
        val li: LayoutInflater = (LayoutInflater.from(context))
        val view = li.inflate(R.layout.dialog_legendas, null)
        val finish = view.findViewById<TextView>(R.id.textViewFechar)

        builder.setView(view)

        val alertDialog: AlertDialog = builder.create()
        alertDialog.setCanceledOnTouchOutside(false)

        finish.setOnClickListener {
            alertDialog.dismiss()
        }

        alertDialog.show()
    }

}

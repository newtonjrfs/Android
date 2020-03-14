package br.com.newton.appmax.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.newton.appmax.R
import br.com.newton.appmax.model.view.Pedidos
import br.com.newton.appmax.presenter.PedidosPresenter
import br.com.newton.appmax.task.PedidosInterface
import br.com.newton.appmax.view.adapters.PedidosAdapter

/**
 * A simple [Fragment] subclass.
 */
class PedidosFragment : Fragment(), PedidosInterface.ViewPedidosInterface {

    val presenter by lazy { PedidosPresenter(this) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        activity!!.setTitle(R.string.historico_de_pedidos)
        return inflater.inflate(R.layout.fragment_pedidos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.searchPedidos()

    }

    override fun showPedidos(list: java.util.ArrayList<Pedidos>) {

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
    }
}

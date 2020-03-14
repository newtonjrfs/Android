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
import br.com.newton.appmax.view.adapters.PedidosAdapter
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

/**
 * A simple [Fragment] subclass.
 */
class PedidosFragment : Fragment() {

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
        val list = ArrayList<Pedidos>()
        list.add(
            Pedidos(
                pedido = "5.421.800.637 / 5.421.800.637",
                cliente = "848.246-A F DA SILVA TUCUMA",
                status = "Pendente",
                legendas = null,
                horarios = SimpleDateFormat("dd-MM-yyyy-hh-mm-ss").format(Date()),
                valor = "R$ 5000,00",
                critica = "SUCESSO",
                tipo = "PEDIDO"
            )
        )
        list.add(
            Pedidos(
                pedido = "5.421.800.637 / 5.421.800.637",
                cliente = "848.246-A F DA SILVA TUCUMA",
                status = "Em processamento",
                legendas = null,
                horarios = SimpleDateFormat("dd-MM-yyyy-hh-mm-ss").format(Date()),
                valor = "R$ 5000,00",
                critica = "SUCESSO",
                tipo = "PEDIDO"
            )
        )
        list.add(
            Pedidos(
                pedido = "5.421.800.637 / 5.421.800.637",
                cliente = "848.246-A F DA SILVA TUCUMA",
                status = "Recusado",
                legendas = null,
                horarios = SimpleDateFormat("dd-MM-yyyy-hh-mm-ss").format(Date()),
                valor = "R$ 5000,00",
                critica = "SUCESSO",
                tipo = "PEDIDO"
            )
        )
        list.add(
            Pedidos(
                pedido = "5.421.800.637 / 5.421.800.637",
                cliente = "848.246-A F DA SILVA TUCUMA",
                status = "Bloqueado",
                legendas = null,
                horarios = SimpleDateFormat("dd-MM-yyyy-hh-mm-ss").format(Date()),
                valor = "R$ 5000,00",
                critica = "SUCESSO",
                tipo = "PEDIDO"
            )
        )
        list.add(
            Pedidos(
                pedido = "5.421.800.637 / 5.421.800.637",
                cliente = "848.246-A F DA SILVA TUCUMA",
                status = "Liberado",
                legendas = null,
                horarios = SimpleDateFormat("dd-MM-yyyy-hh-mm-ss").format(Date()),
                valor = "R$ 5000,00",
                critica = "SUCESSO",
                tipo = "PEDIDO"
            )
        )
        list.add(
            Pedidos(
                pedido = "5.421.800.637 / 5.421.800.637",
                cliente = "848.246-A F DA SILVA TUCUMA",
                status = "Montado",
                legendas = null,
                horarios = SimpleDateFormat("dd-MM-yyyy-hh-mm-ss").format(Date()),
                valor = "R$ 5000,00",
                critica = "SUCESSO",
                tipo = "PEDIDO"
            )
        )
        list.add(
            Pedidos(
                pedido = "5.421.800.637 / 5.421.800.637",
                cliente = "848.246-A F DA SILVA TUCUMA",
                status = "Faturado",
                legendas = null,
                horarios = SimpleDateFormat("dd-MM-yyyy-hh-mm-ss").format(Date()),
                valor = "R$ 5000,00",
                critica = "SUCESSO",
                tipo = "PEDIDO"
            )
        )
        val listt = ArrayList<String>()
        listt.add("PEDIDO_CANCELADO_ERP")
        list.add(
            Pedidos(
                pedido = "5.421.800.637 / 5.421.800.637",
                cliente = "848.246-A F DA SILVA TUCUMA",
                status = "Cancelado",
                legendas = listt,
                horarios = SimpleDateFormat("dd-MM-yyyy-hh-mm-ss").format(Date()),
                valor = "R$ 5000,00",
                critica = null,
                tipo = "PEDIDO"
            )
        )

        populatePedidos(list)
    }

    private fun populatePedidos(list: java.util.ArrayList<Pedidos>) {

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

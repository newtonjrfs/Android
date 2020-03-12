package br.com.newton.appmax.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.newton.appmax.R

/**
 * A simple [Fragment] subclass.
 */
class HistoricoPedidosFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        activity!!.setTitle(R.string.historico_de_pedidos)
        return inflater.inflate(R.layout.fragment_historico_pedidos, container, false)
    }

}

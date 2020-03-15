package br.com.newton.appmax.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import br.com.newton.appmax.R
import br.com.newton.appmax.model.view.Pedidos
import br.com.redcode.easyglide.library.load
import br.com.redcode.easyglide.library.loadInView
import java.text.SimpleDateFormat
import java.util.*

class PedidosAdapter(
    private val list: List<Pedidos>
) :
    RecyclerView.Adapter<PedidosAdapter.ViewHolder>() {

    private val ORCAMENTO = "orcamento"
    private val EM_PROCESSAMENTO = "em processamento"
    private val RECUSADO = "recusado"
    private val PENDENTE = "pendente"
    private val PROCESSADO = "processado"
    private val BLOQUEADO = "bloqueado"
    private val LIBERADO = "liberado"
    private val MONTADO = "montado"
    private val FATURADO = "faturado"
    private val CANCELADO = "cancelado"

    private val SUCESSO = "SUCESSO"
    private val FALHA_PARCIAL = "FALHA_PARCIAL"
    private val AGUARDANDO = "AGUARDANDO"

    private val PEDIDO_SOFREU_CORTE = "PEDIDO_SOFREU_CORTE"
    private val PEDIDO_FEITO_TELEMARKETING = "PEDIDO_FEITO_TELEMARKETING"
    private val PEDIDO_CANCELADO_ERP = "PEDIDO_CANCELADO_ERP"
    private val PEDIDO_DEVOLVIDO = "PEDIDO_DEVOLVIDO"
    private val PEDIDO_EM_FALTA = "PEDIDO_EM_FALTA"


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val v =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.viewholder_lista_pedidos, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pedidos = list[position]

        //controlando status e tipo
        if (ORCAMENTO == pedidos.tipo) {
            holder.sigla.text = "O"
            holder.status.text = pedidos.status
            holder.sigla.setBackgroundColor(
                ContextCompat.getColor(
                    holder.itemView.context,
                    R.color.transparente
                )
            )
            holder.sigla.setTextColor(
                ContextCompat.getColor(
                    holder.itemView.context,
                    R.color.colorAccent
                )
            )
            holder.imgBackStatus.setColorFilter(
                ContextCompat.getColor(
                    holder.itemView.context,
                    R.color.gray_orcamento
                )
            )
        } else {
            when (pedidos.status!!.toLowerCase()) {
                EM_PROCESSAMENTO -> {
                    holder.status.text = pedidos.status
                    holder.sigla.text = ""
                    holder.sigla.loadInView(R.drawable.ic_maxima_em_processamento)
                    holder.imgBackStatus.setColorFilter(
                        ContextCompat.getColor(
                            holder.itemView.context,
                            R.color.gray_em_processamento
                        )
                    )
                }
                RECUSADO -> {
                    holder.status.text = pedidos.status
                    holder.sigla.text = "!"
                    holder.sigla.setBackgroundColor(
                        ContextCompat.getColor(
                            holder.itemView.context,
                            R.color.transparente
                        )
                    )
                    holder.sigla.setTextColor(
                        ContextCompat.getColor(
                            holder.itemView.context,
                            R.color.colorAccent
                        )
                    )
                    holder.imgBackStatus.setColorFilter(
                        ContextCompat.getColor(
                            holder.itemView.context,
                            R.color.laranja_recusado
                        )
                    )
                }
                PENDENTE -> {
                    holder.status.text = pedidos.status
                    holder.sigla.text = "P"
                    holder.sigla.setBackgroundColor(
                        ContextCompat.getColor(
                            holder.itemView.context,
                            R.color.transparente
                        )
                    )
                    holder.sigla.setTextColor(
                        ContextCompat.getColor(
                            holder.itemView.context,
                            R.color.colorAccent
                        )
                    )
                    holder.imgBackStatus.setColorFilter(
                        ContextCompat.getColor(
                            holder.itemView.context,
                            R.color.gray_pendente
                        )
                    )
                }
                PROCESSADO -> {
                    holder.status.text = pedidos.status
                    holder.sigla.text = "P"
                    holder.sigla.setBackgroundColor(
                        ContextCompat.getColor(
                            holder.itemView.context,
                            R.color.transparente
                        )
                    )
                    holder.sigla.setTextColor(
                        ContextCompat.getColor(
                            holder.itemView.context,
                            R.color.colorAccent
                        )
                    )
                    holder.imgBackStatus.setColorFilter(
                        ContextCompat.getColor(
                            holder.itemView.context,
                            R.color.gray_pendente
                        )
                    )
                }
                BLOQUEADO -> {
                    holder.status.text = pedidos.status
                    holder.sigla.text = "B"
                    holder.sigla.setBackgroundColor(
                        ContextCompat.getColor(
                            holder.itemView.context,
                            R.color.transparente
                        )
                    )
                    holder.sigla.setTextColor(
                        ContextCompat.getColor(
                            holder.itemView.context,
                            R.color.colorAccent
                        )
                    )
                    holder.imgBackStatus.setColorFilter(
                        ContextCompat.getColor(
                            holder.itemView.context,
                            R.color.blue_bloqueado
                        )
                    )
                }
                LIBERADO -> {
                    holder.status.text = pedidos.status
                    holder.sigla.text = "L"
                    holder.sigla.setBackgroundColor(
                        ContextCompat.getColor(
                            holder.itemView.context,
                            R.color.transparente
                        )
                    )
                    holder.sigla.setTextColor(
                        ContextCompat.getColor(
                            holder.itemView.context,
                            R.color.colorAccent
                        )
                    )
                    holder.imgBackStatus.setColorFilter(
                        ContextCompat.getColor(
                            holder.itemView.context,
                            R.color.blue_liberado
                        )
                    )
                }
                MONTADO -> {
                    holder.status.text = pedidos.status
                    holder.sigla.text = "M"
                    holder.sigla.setBackgroundColor(
                        ContextCompat.getColor(
                            holder.itemView.context,
                            R.color.transparente
                        )
                    )
                    holder.sigla.setTextColor(
                        ContextCompat.getColor(
                            holder.itemView.context,
                            R.color.colorAccent
                        )
                    )
                    holder.imgBackStatus.setColorFilter(
                        ContextCompat.getColor(
                            holder.itemView.context,
                            R.color.green_montado
                        )
                    )
                }
                FATURADO -> {
                    holder.status.text = pedidos.status
                    holder.sigla.text = "F"
                    holder.sigla.setBackgroundColor(
                        ContextCompat.getColor(
                            holder.itemView.context,
                            R.color.transparente
                        )
                    )
                    holder.sigla.setTextColor(
                        ContextCompat.getColor(
                            holder.itemView.context,
                            R.color.colorAccent
                        )
                    )
                    holder.imgBackStatus.setColorFilter(
                        ContextCompat.getColor(
                            holder.itemView.context,
                            R.color.green_faturado
                        )
                    )
                }
                CANCELADO -> {
                    holder.status.text = pedidos.status
                    holder.sigla.text = "C"
                    holder.sigla.setBackgroundColor(
                        ContextCompat.getColor(
                            holder.itemView.context,
                            R.color.transparente
                        )
                    )
                    holder.sigla.setTextColor(
                        ContextCompat.getColor(
                            holder.itemView.context,
                            R.color.colorAccent
                        )
                    )
                    holder.imgBackStatus.setColorFilter(
                        ContextCompat.getColor(
                            holder.itemView.context,
                            R.color.red_cancelado
                        )
                    )
                }
            }
        }

        //controlando numero do pedido
        holder.numeroPedido.text = pedidos.pedido

        //controlando o cliente
        holder.cliente.text = pedidos.cliente

        //controlando horario
        pedidos.horarios?.let {
            val horarioPedido =
                SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ssz", Locale.ROOT).parse(it)
            val dataAtual = SimpleDateFormat("dd/MM", Locale.ROOT).format(Date())
            val dataPedido = SimpleDateFormat("dd/MM", Locale.ROOT).format(horarioPedido)
            if (dataAtual == dataPedido) {
                holder.horario.text = SimpleDateFormat("hh:mm", Locale.ROOT).format(horarioPedido)
            } else {
                holder.horario.text = SimpleDateFormat("dd/MM", Locale.ROOT).format(horarioPedido)
            }
        }


        //controlando o valor
        holder.valor.text = pedidos.valor

        //controlando a critica
        pedidos.critica?.let {
            when (pedidos.critica) {
                SUCESSO -> holder.imgCritica.load(R.drawable.ic_maxima_critica_sucesso)
                FALHA_PARCIAL -> holder.imgCritica.load(R.drawable.ic_maxima_critica_alerta)
                AGUARDANDO -> holder.imgCritica.load(R.drawable.ic_maxima_aguardando_critica)
                else -> holder.imgCritica.load(R.color.colorAccent)
            }
            holder.constraintCritica.visibility = View.VISIBLE
        }

        //controlando a legenda
        when (pedidos.legendas) {
            PEDIDO_SOFREU_CORTE -> holder.imgLegenda.load(R.drawable.ic_maxima_legenda_corte)
            PEDIDO_FEITO_TELEMARKETING -> holder.imgLegenda.load(R.drawable.ic_maxima_legenda_telemarketing)
            PEDIDO_CANCELADO_ERP -> holder.imgLegenda.load(R.drawable.ic_maxima_legenda_cancelamento)
            PEDIDO_DEVOLVIDO -> holder.imgLegenda.load(R.drawable.ic_maxima_legenda_devolucao)
            PEDIDO_EM_FALTA -> holder.imgLegenda.load(R.drawable.ic_maxima_legenda_falta)
            else -> holder.imgLegenda.load(R.color.colorAccent)
        }
    }

    class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        val sigla = itemView.findViewById(R.id.textViewSiglaStatus) as TextView
        val status = itemView.findViewById(R.id.textViewStatus) as TextView
        val numeroPedido = itemView.findViewById(R.id.textViewNumeroPedido) as TextView
        val cliente = itemView.findViewById(R.id.textViewCliente) as TextView
        val valor = itemView.findViewById(R.id.textViewValor) as TextView
        val imgCritica = itemView.findViewById(R.id.imageViewCritica) as ImageView
        val imgLegenda = itemView.findViewById(R.id.imageViewLegendas) as ImageView
        val imgBackStatus = itemView.findViewById(R.id.imageViewBackStatus) as ImageView
        val horario = itemView.findViewById(R.id.textViewHorario) as TextView
        val constraintCritica =
            itemView.findViewById(R.id.constraintLayoutCritica) as ConstraintLayout


    }
}
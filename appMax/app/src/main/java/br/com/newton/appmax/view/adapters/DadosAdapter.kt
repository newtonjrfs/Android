package br.com.newton.appmax.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.newton.appmax.R
import br.com.newton.appmax.model.view.Contatos

class DadosAdapter(
    private val list: List<Contatos>
) :
    RecyclerView.Adapter<DadosAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val v =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.viewholder_lista_contatos, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contatos = list[position]

        holder.celular.text = contatos.celular
        holder.conjuge.text = contatos.conjuge
        holder.tipo.text = contatos.tipo
        holder.email.text = contatos.email
        holder.dataNasc.text = contatos.dataNascimento
        holder.dataNascConj.text = contatos.dataNascimentoConjuge
        holder.time.text = contatos.time


    }

    class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        val nome = itemView.findViewById(R.id.textViewNome) as TextView
        val telefone = itemView.findViewById(R.id.textViewTelefone) as TextView
        val celular = itemView.findViewById(R.id.textViewCelular) as TextView
        val conjuge = itemView.findViewById(R.id.textViewConjuge) as TextView
        val tipo = itemView.findViewById(R.id.textViewTipo) as TextView
        val email = itemView.findViewById(R.id.textViewEmail) as TextView
        val dataNasc = itemView.findViewById(R.id.textViewDataNascimento) as TextView
        val dataNascConj = itemView.findViewById(R.id.textViewDataNascimentoConjuge) as TextView
        val time = itemView.findViewById(R.id.textViewTime) as TextView

    }
}
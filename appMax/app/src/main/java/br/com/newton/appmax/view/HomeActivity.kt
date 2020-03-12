package br.com.newton.appmax.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.newton.appmax.R
import br.com.redcode.easyglide.library.load
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        imageViewClientes.load(R.drawable.ic_maxima_pessoas)
        imageViewPedidos.load(R.drawable.ic_maxima_pedido)
        imageViewResumo.load(R.drawable.ic_maxima_resumo_vendas)
        imageViewFerramentas.load(R.drawable.ic_maxima_ferramentas)

    }
}

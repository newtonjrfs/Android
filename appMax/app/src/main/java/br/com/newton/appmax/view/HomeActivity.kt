package br.com.newton.appmax.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.newton.appmax.R
import br.com.newton.appmax.presenter.HomePresenter
import br.com.newton.appmax.task.HomeInterface
import br.com.redcode.easyglide.library.load
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), HomeInterface.ViewHomeInterface {

    private val presenter by lazy { HomePresenter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        imageViewClientes.load(R.drawable.ic_maxima_pessoas)
        imageViewPedidos.load(R.drawable.ic_maxima_pedido)
        imageViewResumo.load(R.drawable.ic_maxima_resumo_vendas)
        imageViewFerramentas.load(R.drawable.ic_maxima_ferramentas)

        presenter.verifyInternet(this)
        presenter.verifyVersion()

        constraintLayoutClientes.setOnClickListener {
            startActivity(Intent(this, ClienteActivity::class.java))
        }

    }

    override fun showInternet(internet: Boolean) {
        if (internet) {
            imageViewInternet.load(R.drawable.ic_maxima_nuvem_conectado)
        } else {
            imageViewInternet.load(R.drawable.ic_maxima_nuvem_desconectado)
        }
    }

    override fun showVersion(version: String) {
        textViewVersao.text = getString(R.string.version_home, version)
    }
}

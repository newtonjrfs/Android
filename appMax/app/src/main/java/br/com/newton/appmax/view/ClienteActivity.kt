package br.com.newton.appmax.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import br.com.newton.appmax.R
import kotlinx.android.synthetic.main.activity_cliente.*


class ClienteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cliente)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentCliente, DadosFragment()).commit()
        }

        bottomNavigationViewCliente.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.dados -> startFragment(DadosFragment())
                R.id.historico -> startFragment(HistoricoPedidosFragment())
                R.id.alvaras -> startFragment(AlvarasFragment())
            }
            true
        }
    }

    private fun startFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentCliente, fragment).commit()
    }
}

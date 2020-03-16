package br.com.newton.appmax.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import br.com.newton.appmax.R
import br.com.newton.appmax.view.fragment.AlvarasFragment
import br.com.newton.appmax.view.fragment.DadosFragment
import br.com.newton.appmax.view.fragment.PedidosFragment
import kotlinx.android.synthetic.main.activity_cliente.*


class ClienteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cliente)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(
                    R.id.fragmentCliente,
                    DadosFragment()
                ).commit()
        }

        bottomNavigationViewCliente.setOnNavigationItemSelectedListener {

            if (bottomNavigationViewCliente.selectedItemId != it.itemId) {
                when (it.itemId) {
                    R.id.dados -> startFragment(DadosFragment())
                    R.id.historico -> startFragment(
                        PedidosFragment()
                    )
                    R.id.alvaras -> startFragment(AlvarasFragment())
                }
            }
            true
        }
    }

    private fun startFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentCliente, fragment)
            .addToBackStack(null)
            .commit()
    }


    override fun onBackPressed() {
        super.onBackPressed()
        if (supportFragmentManager.backStackEntryCount > 1) {
            supportFragmentManager.popBackStack()
        }
    }


}

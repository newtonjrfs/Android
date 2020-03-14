package br.com.newton.appmax.view.activity

import android.os.Bundle
import android.view.MenuItem
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
            when (it.itemId) {
                R.id.dados -> startFragment(DadosFragment())
                R.id.historico -> addFragment(PedidosFragment())
                R.id.alvaras -> addFragment(AlvarasFragment())
            }
            true
        }
    }

    private fun startFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentCliente, fragment).commit()

        //supportFragmentManager.backStackEntryCount > 1
        //pop back para remover
    }

    private fun addFragment(fragment: Fragment) {

        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentCliente, fragment)
            .addToBackStack(null)
            .commit()

        //supportFragmentManager.backStackEntryCount > 1
        //pop back para remover
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)

    }




}

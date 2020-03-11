package br.com.newton.appmax

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import br.com.redcode.easyglide.library.load
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        imageViewLogo.load(R.drawable.maxima_logotipo)

        val handle = Handler()
        handle.postDelayed(Runnable {
            startActivity(Intent(this,HomeActivity::class.java))
        }, 2000)

    }
}

package br.com.newton.appmax.presenter

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.os.Build
import br.com.newton.appmax.BuildConfig
import br.com.newton.appmax.task.HomeInterface

class HomePresenter(val view: HomeInterface.ViewHomeInterface) :
    HomeInterface.PresenterHomeInterface {

    override fun getVersion() {
        val version = BuildConfig.VERSION_NAME
        view.showVersion(version)
    }

    override fun getInternet(context: Context) {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        if (Build.VERSION.SDK_INT >= 29) {
            connectivityManager.registerDefaultNetworkCallback(object :
                ConnectivityManager.NetworkCallback() {
                override fun onAvailable(network: Network) {
                    super.onAvailable(network)
                    view.showInternet(true)
                }

                override fun onLost(network: Network) {
                    super.onLost(network)
                    view.showInternet(false)
                }
            })
        } else {
            val networkInfo = connectivityManager.activeNetworkInfo
            val network = networkInfo != null && networkInfo.isConnected
            view.showInternet(network)
        }


    }

}
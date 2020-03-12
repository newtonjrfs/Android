package br.com.newton.appmax.task

import android.content.Context

interface HomeInterface {

    interface PresenterHomeInterface {
        fun getInternet(context: Context)
        fun getVersion()

    }

    interface ViewHomeInterface {
        fun showInternet(internet: Boolean)
        fun showVersion(version: String)

    }

}
package br.com.newton.appmax.task

import android.content.Context

interface HomeInterface {

    interface PresenterHomeInterface {
        fun verifyInternet(context: Context)
        fun verifyVersion()

    }

    interface ViewHomeInterface {
        fun showInternet(internet: Boolean)
        fun showVersion(version: String)

    }

}
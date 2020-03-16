package br.com.newton.appmax.dao

import android.app.Application
import android.content.Context
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import br.com.newton.appmax.general.SyncWorker
import java.lang.ref.WeakReference
import java.util.concurrent.TimeUnit

class App : Application() {

    var statusApp = false

    companion object {
        private lateinit var mContext: WeakReference<Context>
        fun getContext() = mContext.get()
    }

    override fun onCreate() {
        super.onCreate()
        mContext = WeakReference(this)
        statusApp = true

        val jobSyncWorker = PeriodicWorkRequest.Builder(
            SyncWorker::class.java,
            5,
            TimeUnit.MINUTES,
            1,
            TimeUnit.MILLISECONDS
        ).build()
        WorkManager.getInstance(this).enqueue(jobSyncWorker)
    }

    override fun onTerminate() {
        super.onTerminate()
        statusApp = false
    }


}
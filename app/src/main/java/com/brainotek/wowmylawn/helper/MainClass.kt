package com.brainotek.wowmylawn.helper

import android.app.Application
import android.content.ContextWrapper
import com.brainotek.wowmylawn.koin.module.NetworkModule
import com.brainotek.wowmylawn.koin.module.RepositoryModule
import com.brainotek.wowmylawn.koin.module.ViewModelModule
import com.brainotek.wowmylawn.storage.Prefs
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class MainClass: Application()
{
    private val appModules = listOf(
        NetworkModule,
        RepositoryModule,
        ViewModelModule
    )

    override fun onCreate() {
        super.onCreate()

        /**
         * Initialize or Start Koin
         */
        startKoin {
            androidContext(this@MainClass)
            modules(appModules)
        }

        /**
         * Initialize the Prefs class
         */
        Prefs.Builder()
            .setContext(this)
            .setMode(ContextWrapper.MODE_PRIVATE)
            .setPrefsName(packageName)
            .setUseDefaultSharedPreference(true)
            .build()
    }
}
package com.brainotek.wowmylawn.koin

import android.app.Application
import com.brainotek.wowmylawn.network.SoService
import com.brainotek.wowmylawn.network.domain.DataSource
import com.brainotek.wowmylawn.repository.AppRepository
import com.brainotek.wowmylawn.repository.UserRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject


object InjectUtils : KoinComponent
{
    /**
     * Get Single instance of Application Context
     */
    val appContext: Application by inject()

    /**
     * Get Single instance of Retrofit WEB API Service
     */
    val getRetrofit: SoService by inject()

    /**
     * Get Single instance of [AppRepository] to access all data type repos.
     */
    val appRepository: AppRepository by inject()

    /**
     * Get Single instance of [DataSource] containing all api calls.
     */
    val dataSource: DataSource by inject()

    /**
     * Get Single instance of [UserRepository]
     */
    val userRepository: UserRepository by inject()
}
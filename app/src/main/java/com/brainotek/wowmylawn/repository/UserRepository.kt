package com.brainotek.wowmylawn.repository

import com.brainotek.wowmylawn.koin.InjectUtils
import com.brainotek.wowmylawn.model.request.LoginRequest
import com.brainotek.wowmylawn.network.domain.performNetworkCallOperation
import com.brainotek.wowmylawn.storage.AppPreferences


class UserRepository {

    private var remoteDataSource = InjectUtils.dataSource

    suspend fun login(loginRequest: LoginRequest) = performNetworkCallOperation(
        networkCall = {
            remoteDataSource.login(loginRequest)
        },
        saveCallResult = {
            if (it.success!!) {
                AppPreferences.loginData = it
            }
        }
    )

}
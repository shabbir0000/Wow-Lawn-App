package com.brainotek.wowmylawn.network.domain

import com.brainotek.wowmylawn.koin.InjectUtils
import com.brainotek.wowmylawn.model.request.LoginRequest



class DataSource : BaseDataSource() {

    private var apiService = InjectUtils.getRetrofit

    /**
     * Define All webServices instances here &
     * Get results in [callApi] callback
     */
    suspend fun login(loginRequest: LoginRequest) = callApi {
        apiService.login(loginRequest)
    }
}
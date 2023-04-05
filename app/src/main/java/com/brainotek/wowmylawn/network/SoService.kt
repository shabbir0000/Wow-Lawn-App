package com.brainotek.wowmylawn.network

import com.brainotek.wowmylawn.model.request.LoginRequest
import com.brainotek.wowmylawn.model.request.RegistrationRequest
import com.brainotek.wowmylawn.model.response.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface SoService
{
    @POST(Routes.LOGIN)
    suspend fun login(@Body loginRequest: LoginRequest): Response<LoginResponse>

}
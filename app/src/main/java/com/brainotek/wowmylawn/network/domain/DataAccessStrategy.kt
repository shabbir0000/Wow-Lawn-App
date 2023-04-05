package com.brainotek.wowmylawn.network.domain

import com.brainotek.wowmylawn.network.ApiResponseCallback


suspend fun <T> performNetworkCallOperation(
    networkCall: suspend () -> ApiResponseCallback<T>,
): ApiResponseCallback<T> {

    val responseStatus = networkCall.invoke()
    responseStatus.data?.let { response ->
        return ApiResponseCallback.Success(response)
    }
    return ApiResponseCallback.Error(responseStatus.message, responseStatus.code,responseStatus.error)
}

suspend fun <T> performNetworkCallOperation(
    networkCall: suspend () -> ApiResponseCallback<T>,
    saveCallResult: suspend (T) -> Unit
): ApiResponseCallback<T> {

    val responseStatus = networkCall.invoke()
    responseStatus.data?.let { response ->
        saveCallResult(response)
        return ApiResponseCallback.Success(response)
    }
    return ApiResponseCallback.Error(responseStatus.message, responseStatus.code,responseStatus.error)
}
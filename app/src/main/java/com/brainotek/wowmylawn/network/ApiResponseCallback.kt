package com.brainotek.wowmylawn.network


sealed class ApiResponseCallback<T>(
    val data: T? = null,
    var code: Int? = null,
    val message: String? = null,
    val error: Any? = null

) {
    class Loading<T> : ApiResponseCallback<T>()
    class Success<T>(data: T) : ApiResponseCallback<T>(data)
    class Error<T>(message: String?, code: Int?,error: Any? ,data: T? = null) : ApiResponseCallback<T>(data, code, message,error)
}
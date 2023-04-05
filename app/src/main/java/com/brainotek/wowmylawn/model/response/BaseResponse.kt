package com.brainotek.wowmylawn.model.response

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


open class BaseResponse
{
    @SerializedName("success")
    @Expose
    val success: Boolean? = null

    @SerializedName("message")
    @Expose
    val message: String? = null
}
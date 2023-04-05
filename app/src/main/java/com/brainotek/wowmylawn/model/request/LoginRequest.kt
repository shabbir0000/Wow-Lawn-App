package com.brainotek.wowmylawn.model.request

import com.google.gson.annotations.SerializedName
import org.apache.commons.lang3.StringUtils


data class LoginRequest(

    @SerializedName("email")
    var email: String = StringUtils.EMPTY,

    @SerializedName("password")
    var password: String = StringUtils.EMPTY,

    @SerializedName("device_token")
    var device_token: String = StringUtils.EMPTY
)
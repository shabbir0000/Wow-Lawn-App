package com.brainotek.wowmylawn.network.domain

import com.google.gson.annotations.SerializedName
import org.apache.commons.lang3.StringUtils


/**
 * Created by Mustufa Ansari on 15/09/2022
 * Email: mustufaayub82@gmail.com
 */

data class ResponseError(
    @SerializedName("errors") var errors: Errors? = Errors()
)


data class Errors(
    @SerializedName("error") var error: String? = null,
    @SerializedName("password") var password: ArrayList<String>? = arrayListOf(),
    @SerializedName("email") var email: ArrayList<String>? = arrayListOf(),
)
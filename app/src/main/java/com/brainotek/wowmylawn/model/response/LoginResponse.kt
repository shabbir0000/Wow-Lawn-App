package com.brainotek.wowmylawn.model.response

import com.brainotek.wowmylawn.model.User
import com.google.gson.annotations.SerializedName


data class LoginResponse (
  @SerializedName("data"    ) var data    : User?    = User()

) : BaseResponse()
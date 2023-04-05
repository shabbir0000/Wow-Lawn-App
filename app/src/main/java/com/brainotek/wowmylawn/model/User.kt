package com.brainotek.wowmylawn.model

import com.google.gson.annotations.SerializedName


data class User (

  @SerializedName("id"         ) var id        : Int?    = null,
  @SerializedName("name"       ) var name      : String? = null,
  @SerializedName("email"      ) var email     : String? = null,
  @SerializedName("phone"      ) var phone     : String? = null,
  @SerializedName("image"      ) var image     : String? = null,
  @SerializedName("created_at" ) var createdAt : String? = null,
  @SerializedName("updated_at" ) var updatedAt : String? = null,
  @SerializedName("type"       ) var type      : String? = null,
  @SerializedName("token"      ) var token     : String? = null

)
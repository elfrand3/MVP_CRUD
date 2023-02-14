package com.elcodee.mvpcrud.model.data.response

import com.google.gson.annotations.SerializedName

data class ResponsePut(
    @SerializedName("name") val name : String,
    @SerializedName("job") val job : String,
    @SerializedName("updatedAt") val updatedAt : String
)

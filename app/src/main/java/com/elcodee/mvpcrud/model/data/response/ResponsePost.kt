package com.elcodee.mvpcrud.model.data.response

import com.google.gson.annotations.SerializedName

data class ResponsePost (
    @SerializedName("name") val name : String,
    @SerializedName("job") val job : String,
    @SerializedName("id") val id : String,
    @SerializedName("createdAt") val createdAt : String
)
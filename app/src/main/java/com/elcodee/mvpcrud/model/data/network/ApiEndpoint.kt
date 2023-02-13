package com.elcodee.mvpcrud.model.data.network

import com.elcodee.mvpcrud.model.data.response.ResponseGet
import com.elcodee.mvpcrud.model.data.response.ResponsePost
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiEndpoint {

    @GET("api/users?page=2")
    fun getData():Call<ResponseGet>

    @POST("api/users")
    fun postData(
        @Body data: JsonObject
    ): Call<ResponsePost>
}
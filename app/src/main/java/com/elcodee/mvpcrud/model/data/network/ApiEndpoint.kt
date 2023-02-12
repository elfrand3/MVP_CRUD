package com.elcodee.mvpcrud.model.data.network

import com.elcodee.mvpcrud.model.data.response.ResponseGet
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndpoint {

    @GET("api/users?page=2")
    fun getData():Call<ResponseGet>
}
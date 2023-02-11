package com.elcodee.mvpcrud.Model.data.network

import com.elcodee.mvpcrud.Model.data.response.ResponseGet
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndpoint {

    @GET("api/users?page=2")
    fun getData():Call<ResponseGet>
}
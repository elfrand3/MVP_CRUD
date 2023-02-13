package com.elcodee.mvpcrud.presenter

import android.widget.Toast
import com.elcodee.mvpcrud.model.contract.PostContact
import com.elcodee.mvpcrud.model.data.network.ApiService
import com.elcodee.mvpcrud.model.data.response.ResponsePost
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostPresenter(val view: PostContact.View): PostContact.Presenter {

    init {
        view.initActivity()
        view.initListener()
    }
    override fun postData(data: JsonObject) {
        ApiService.getInstance().postData(data).enqueue(object : Callback<ResponsePost>{
            override fun onResponse(call: Call<ResponsePost>, response: Response<ResponsePost>) {
                if (response.isSuccessful){
                    view.onMessage("berhasil")
                }else{
                    view.onMessage("gagal")
                }
            }

            override fun onFailure(call: Call<ResponsePost>, t: Throwable) {
                view.onMessage("$t")
            }
        })
    }

}
package com.elcodee.mvpcrud.presenter

import com.elcodee.mvpcrud.model.contract.PutContract
import com.elcodee.mvpcrud.model.data.network.ApiService
import com.elcodee.mvpcrud.model.data.response.ResponsePut
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PutPresenter(val view: PutContract.View): PutContract.Presenter {
    init {
        view.initActivity()
        view.initListener()
    }
    override fun putData(update: JsonObject) {
        ApiService.getInstance().putData(update).enqueue(object : Callback<ResponsePut>{
            override fun onResponse(call: Call<ResponsePut>, response: Response<ResponsePut>) {
                if (response.isSuccessful){
                    view.onMessage("update success")
                }else{
                    view.onMessage("update not success")
                }
            }

            override fun onFailure(call: Call<ResponsePut>, t: Throwable) {
                view.onMessage("$t")
            }
        })
    }
}
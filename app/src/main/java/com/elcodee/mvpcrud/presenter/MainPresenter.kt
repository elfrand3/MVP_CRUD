package com.elcodee.mvpcrud.presenter

import com.elcodee.mvpcrud.model.contract.MainContract
import com.elcodee.mvpcrud.model.data.network.ApiService
import com.elcodee.mvpcrud.model.data.response.ResponseGet
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(val view: MainContract.View): MainContract.Presenter {

    init {
        view.initActivity()
        view.initListener()
    }
    override fun getData() {
        ApiService.getInstance().getData().enqueue(object : Callback<ResponseGet>{
            override fun onResponse(call: Call<ResponseGet>, response: Response<ResponseGet>) {
                if (response.isSuccessful){
                    val responseData: ResponseGet? = response.body()
                    view.setData(responseData!!)
                }
            }

            override fun onFailure(call: Call<ResponseGet>, t: Throwable) {
                view.onMessage("$t")
            }
        })
    }
}
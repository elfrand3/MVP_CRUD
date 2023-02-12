package com.elcodee.mvpcrud.model.contract

import com.elcodee.mvpcrud.model.data.response.ResponseGet

interface MainContract {

    interface Presenter {
        fun getData()
    }
    interface View {
        fun initActivity()
        fun initListener()
        fun onMessage(Message: String)
        fun setData(response: ResponseGet)
    }

}
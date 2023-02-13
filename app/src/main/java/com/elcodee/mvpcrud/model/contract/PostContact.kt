package com.elcodee.mvpcrud.model.contract

import com.elcodee.mvpcrud.model.data.response.ResponsePost
import com.google.gson.JsonObject

interface PostContact {
    interface Presenter{
        fun postData(data: JsonObject)
    }
    interface View {
        fun initActivity()
        fun initListener()
        fun onMessage(Message: String)
    }
}
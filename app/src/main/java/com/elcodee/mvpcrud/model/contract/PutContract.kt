package com.elcodee.mvpcrud.model.contract

import com.google.gson.JsonObject

interface PutContract {
    interface Presenter{
        fun putData(update: JsonObject)
    }
    interface View {
        fun initActivity()
        fun initListener()
        fun onMessage(Message: String)
    }
}
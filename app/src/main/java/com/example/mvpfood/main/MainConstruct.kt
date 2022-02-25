package com.example.mvpfood.main

import com.example.mvpfood.base.BaseView
import com.example.mvpfood.model.DataItem

interface MainConstruct {
    interface view : BaseView{
        fun showDataFood(dataFood : List<DataItem?>?)
        fun showError(msg: String)
        fun showMessage(msg: String)
        fun onSuccessInsert()
    }

    interface Presenter {
        fun getAllFood()
        fun insertFood(nameFood: String, priceFood: String, imgFood: String)
    }
}
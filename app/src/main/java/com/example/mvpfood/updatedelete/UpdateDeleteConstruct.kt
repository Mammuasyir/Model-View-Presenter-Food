package com.example.mvpfood.updatedelete

import com.example.mvpfood.base.BaseView

interface UpdateDeleteConstruct {

    interface view: BaseView {
        fun showMessageUpdate(msg : String)
        fun showMessageDelete(msg : String)
        fun showError(error : String)
        fun onSuccessDelete()
        fun onSuccessUpdate()
    }
    interface Presenter{
        fun updateFood (idFood: String, nameFood: String, priceFood: String, imgFood: String)
        fun deleteFood (idFood: String)
    }

}
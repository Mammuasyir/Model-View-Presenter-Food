package com.example.mvpfood.updatedelete

import com.example.mvpfood.api.ApiConfig
import com.example.mvpfood.base.BasePresenter
import com.example.mvpfood.main.MainActivity
import com.example.mvpfood.model.ResponseGetFood
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*


class UpdateDeletePresenter (var updateDeleteView : UpdateDeleteActivity) : BasePresenter<UpdateDeleteConstruct.view>, UpdateDeleteConstruct.Presenter {
    override fun onAttach(view: MainActivity) {
        TODO("Not yet implemented")
    }

    override fun onDetach() {
      updateDeleteView
    }

    override fun onAttach(view: UpdateDeleteConstruct) {
       updateDeleteView
    }

    override fun updateFood(idFood: String, nameFood: String, priceFood: String, imgFood: String) {
        ApiConfig.service.updateFood(idFood,nameFood,priceFood,imgFood).enqueue(object :Callback<ResponseGetFood>{
            override fun onResponse(
                call: Call<ResponseGetFood>,
                response: Response<ResponseGetFood>
            ) {
                if (response.isSuccessful || response.code() == 200) {
                    val msg = response.body()?.pesan
                    val sukses = response.body()?.sukses

                    if (sukses != false) {
                        val dataFood = response.body()?.data
                        updateDeleteView?.showMessageUpdate(msg.toString())
                        updateDeleteView?.onSuccessUpdate()
                    } else {
                        updateDeleteView?.showMessageUpdate(msg.toString())
                    }

                }
            }

            override fun onFailure(call: Call<ResponseGetFood>, t: Throwable) {
                updateDeleteView?.showError(t.localizedMessage.toString())
            }

        })
    }

    override fun deleteFood(idFood: String) {
    ApiConfig.service.deleteFood(idFood).enqueue(object : Callback<ResponseGetFood>{
            override fun onResponse(
                call: Call<ResponseGetFood>,
                response: Response<ResponseGetFood>
            ) {
                if (response.isSuccessful || response.code() == 200) {
                    val msg = response.body()?.pesan
                    val sukses = response.body()?.sukses

                    if (sukses != false) {
                        val dataFood = response.body()?.data
                        updateDeleteView?.showMessageDelete(msg.toString())
                        updateDeleteView?.onSuccessDelete()
                    } else {
                        updateDeleteView?.showMessageDelete(msg.toString())
                    }

                }
        }

        override fun onFailure(call: Call<ResponseGetFood>, t: Throwable) {
            TODO("Not yet implemented")
        }
    })
    }

}
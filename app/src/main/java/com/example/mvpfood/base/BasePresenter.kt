package com.example.mvpfood.base

import com.example.mvpfood.main.MainActivity
import com.example.mvpfood.updatedelete.UpdateDeleteConstruct

interface BasePresenter<T : BaseView> {
    fun onAttach(view: MainActivity)
    fun onDetach()
    fun onAttach(view: UpdateDeleteConstruct)
}
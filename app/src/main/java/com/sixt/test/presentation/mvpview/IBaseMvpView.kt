package com.sixt.test.presentation.mvpview

import androidx.annotation.StringRes
import moxy.MvpView

interface IBaseMvpView: MvpView {

    fun showProgressDialog()

    fun hideProgressDialog()

    fun showErrorToast(error: String)

    fun showErrorToast(@StringRes resId : Int)

}
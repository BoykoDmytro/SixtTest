package com.sixt.test.presentation.presenter.splash

import com.sixt.test.presentation.mvpview.splash.SplashView
import com.sixt.test.presentation.presenter.BasePresenter
import moxy.InjectViewState

@InjectViewState
class SplashPresenter : BasePresenter<SplashView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.navigateToHome()
    }
}
package com.sixt.test.presentation.presenter.home

import com.sixt.test.presentation.mvpview.home.IHomeView
import com.sixt.test.presentation.presenter.BasePresenter
import moxy.InjectViewState

@InjectViewState
class HomePresenter : BasePresenter<IHomeView>()
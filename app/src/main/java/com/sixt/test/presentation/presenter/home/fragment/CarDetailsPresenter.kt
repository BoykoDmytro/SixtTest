package com.sixt.test.presentation.presenter.home.fragment

import com.sixt.test.data.entity.presentation.CarUIItem
import com.sixt.test.presentation.mvpview.home.fragment.CarDetailView
import com.sixt.test.presentation.presenter.BasePresenter
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class CarDetailsPresenter @Inject constructor() : BasePresenter<CarDetailView>() {

    fun setupData(car: CarUIItem?) {
        car?.let { viewState.setupCar(it) }
    }
}
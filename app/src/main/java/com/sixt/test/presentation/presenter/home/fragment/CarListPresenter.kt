package com.sixt.test.presentation.presenter.home.fragment

import com.sixt.test.data.entity.presentation.CarUIItem
import com.sixt.test.presentation.mvpview.home.fragment.CarListView
import com.sixt.test.presentation.presenter.BasePresenter
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class CarListPresenter @Inject constructor() : BasePresenter<CarListView>() {

    fun setupData(cars: List<CarUIItem>?) {
        if (cars.isNullOrEmpty()) {
            viewState.showEmptyView()
        } else {
            viewState.initCars(cars)
        }
    }
}
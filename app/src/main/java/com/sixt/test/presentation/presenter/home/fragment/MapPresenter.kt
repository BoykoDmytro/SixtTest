package com.sixt.test.presentation.presenter.home.fragment

import com.sixt.test.data.entity.presentation.CarUIItem
import com.sixt.test.presentation.mvpview.home.fragment.MapFragmentView
import com.sixt.test.presentation.presenter.BasePresenter
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class MapPresenter @Inject constructor() : BasePresenter<MapFragmentView>() {

    fun setupDate(cars: List<CarUIItem>?) {
        viewState.initCars(cars)
    }

    fun onMarkerClick(car: CarUIItem) {
        viewState.onMarkerClick(car)
    }
}
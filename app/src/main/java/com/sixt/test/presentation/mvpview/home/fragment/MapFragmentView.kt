package com.sixt.test.presentation.mvpview.home.fragment

import com.sixt.test.data.entity.presentation.CarUIItem
import com.sixt.test.presentation.mvpview.IBaseMvpView

interface MapFragmentView : IBaseMvpView {
    fun initCars(cars: List<CarUIItem>?)
    fun onMarkerClick(car: CarUIItem)
}
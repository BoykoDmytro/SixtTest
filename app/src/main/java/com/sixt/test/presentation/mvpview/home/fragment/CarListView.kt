package com.sixt.test.presentation.mvpview.home.fragment

import com.sixt.test.data.entity.presentation.CarUIItem
import com.sixt.test.presentation.mvpview.IBaseMvpView

interface CarListView : IBaseMvpView {

    fun setupCars(cars: List<CarUIItem>)
    fun showEmptyView()
}
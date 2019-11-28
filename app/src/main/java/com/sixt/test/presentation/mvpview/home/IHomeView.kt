package com.sixt.test.presentation.mvpview.home

import com.sixt.test.data.entity.presentation.CarUIItem
import com.sixt.test.presentation.mvpview.IBaseMvpView

interface IHomeView: IBaseMvpView {
    fun updateCars(cars: List<CarUIItem>)
}
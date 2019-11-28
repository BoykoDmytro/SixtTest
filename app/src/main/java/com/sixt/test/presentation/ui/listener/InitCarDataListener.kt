package com.sixt.test.presentation.ui.listener

import com.sixt.test.data.entity.presentation.CarUIItem

interface InitCarDataListener {
    fun setupCars(cars: List<CarUIItem>?)

}
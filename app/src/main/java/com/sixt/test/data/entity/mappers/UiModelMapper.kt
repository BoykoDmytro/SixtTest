package com.sixt.test.data.entity.mappers

import com.sixt.test.data.entity.network.CarResponse
import com.sixt.test.data.entity.presentation.CarUIItem

object UiModelMapper {

    fun map(model: CarResponse): CarUIItem =
        CarUIItem(
            model.id,
            model.modelIdentifier,
            model.modelName,
            model.name,
            model.make,
            model.group,
            model.color,
            model.series,
            model.fuelType,
            model.fuelLevel,
            model.transmission,
            model.licensePlate,
            model.latitude,
            model.longitude,
            model.innerCleanliness,
            model.carImageUrl)

}
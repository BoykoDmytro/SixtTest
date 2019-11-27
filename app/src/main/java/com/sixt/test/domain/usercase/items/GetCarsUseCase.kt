package com.sixt.test.domain.usercase.items

import com.sixt.test.data.entity.mappers.UiModelMapper
import com.sixt.test.data.entity.presentation.CarUIItem
import com.sixt.test.domain.repository.ICarRepository
import com.sixt.test.domain.usercase.BaseCoroutinesUseCase
import javax.inject.Inject

class GetCarsUseCase @Inject constructor(
    private val carRepository: ICarRepository
) : BaseCoroutinesUseCase<List<CarUIItem>>() {

    override suspend fun executeOnBackground(): List<CarUIItem> =
        carRepository.get().map { model -> UiModelMapper.map(model) }
}
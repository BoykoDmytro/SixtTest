package com.sixt.test.data.repository

import com.sixt.test.data.entity.network.CarResponse
import com.sixt.test.data.network.services.ApiCarService
import com.sixt.test.domain.repository.ICarRepository
import javax.inject.Inject

class CarsRepository @Inject constructor(
        private val apiCarService: ApiCarService
) : ICarRepository {

    override suspend fun get(): List<CarResponse> = apiCarService.getCarsAsync().await()
}
package com.sixt.test.domain.repository

import com.sixt.test.data.entity.network.CarResponse

interface ICarRepository {
    suspend fun get(): List<CarResponse>
}
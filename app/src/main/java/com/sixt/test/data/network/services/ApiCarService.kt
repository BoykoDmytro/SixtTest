package com.sixt.test.data.network.services

import com.sixt.test.data.entity.network.CarResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface ApiCarService {

    companion object {
        const val GET_CARS = "/codingtask/cars"
    }

    @GET(GET_CARS)
    fun getCarsAsync(): Deferred<List<CarResponse>>

}
package com.sixt.test.data.entity.presentation

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CarUIItem(
    var id: String? = null,
    var modelIdentifier: String? = null,
    var modelName: String? = null,
    var name: String? = null,
    var make: String? = null,
    var group: String? = null,
    var color: String? = null,
    var series: String? = null,
    var fuelType: String? = null,
    var fuelLevel: Float? = null,
    var transmission: String? = null,
    var licensePlate: String? = null,
    var latitude: Float? = null,
    var longitude: Float? = null,
    var innerCleanliness: String? = null,
    var carImageUrl: String? = null
) : Parcelable
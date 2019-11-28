package com.sixt.test.data.entity.presentation

import android.os.Parcelable
import com.google.android.gms.maps.model.LatLng
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
    var latitude: Double = 0.0,
    var longitude: Double = 0.0,
    var innerCleanliness: String? = null,
    var carImageUrl: String? = null
) : Parcelable {

    fun getLatLng(): LatLng = LatLng(latitude, longitude)

    fun getDescription(): String = "$name with location: $latitude, $longitude"
}
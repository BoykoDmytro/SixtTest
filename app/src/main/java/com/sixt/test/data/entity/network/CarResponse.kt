package com.sixt.test.data.entity.network

import com.google.gson.annotations.SerializedName

data class CarResponse(
    @SerializedName("id")
    var id: String? = null,
    @SerializedName("modelIdentifier")
    var modelIdentifier: String? = null,
    @SerializedName("modelName")
    var modelName: String? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("make")
    var make: String? = null,
    @SerializedName("group")
    var group: String? = null,
    @SerializedName("color")
    var color: String? = null,
    @SerializedName("series")
    var series: String? = null,
    @SerializedName("fuelType")
    var fuelType: String? = null,
    @SerializedName("fuelLevel")
    var fuelLevel: Float? = null,
    @SerializedName("transmission")
    var transmission: String? = null,
    @SerializedName("licensePlate")
    var licensePlate: String? = null,
    @SerializedName("latitude")
    var latitude: Double? = null,
    @SerializedName("longitude")
    var longitude: Double? = null,
    @SerializedName("innerCleanliness")
    var innerCleanliness: String? = null,
    @SerializedName("carImageUrl")
    var carImageUrl: String? = null
)
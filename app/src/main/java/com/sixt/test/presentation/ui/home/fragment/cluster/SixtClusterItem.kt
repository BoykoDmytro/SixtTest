package com.sixt.test.presentation.ui.home.fragment.cluster

import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.clustering.ClusterItem
import com.sixt.test.data.entity.presentation.CarUIItem

class SixtClusterItem(val carUIItem: CarUIItem) : ClusterItem {

    private var latLng: LatLng = carUIItem.getLatLng()

    override fun getPosition(): LatLng = latLng

    override fun getSnippet(): String = carUIItem.name ?: ""

    override fun getTitle(): String = carUIItem.name ?: ""

}
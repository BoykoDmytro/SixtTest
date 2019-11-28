package com.sixt.test.presentation.ui.home.fragment.cluster

import android.content.Context
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.MarkerOptions
import com.google.maps.android.clustering.ClusterManager
import com.google.maps.android.clustering.view.DefaultClusterRenderer
import com.sixt.test.common.iconForDelivery

class SixtMapClusterRenderer(
    val context: Context,
    private val map: GoogleMap,
    clusterManager: ClusterManager<SixtClusterItem>
) : DefaultClusterRenderer<SixtClusterItem>(
    context, map, clusterManager
) {

    override fun onBeforeClusterItemRendered(item: SixtClusterItem, markerOptions: MarkerOptions?) {
        super.onBeforeClusterItemRendered(item, markerOptions)
        markerOptions?.icon(map.iconForDelivery(context))
    }
}
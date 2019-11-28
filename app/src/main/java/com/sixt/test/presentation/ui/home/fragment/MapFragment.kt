package com.sixt.test.presentation.ui.home.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLngBounds
import com.google.maps.android.clustering.ClusterManager
import com.sixt.test.R
import com.sixt.test.data.entity.presentation.CarUIItem
import com.sixt.test.presentation.mvpview.home.fragment.MapFragmentView
import com.sixt.test.presentation.presenter.home.fragment.MapPresenter
import com.sixt.test.presentation.ui.home.fragment.cluster.SixtClusterItem
import com.sixt.test.presentation.ui.home.fragment.cluster.SixtMapClusterRenderer
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject

class MapFragment : BaseSubHomeFragment(), MapFragmentView, OnMapReadyCallback {

    companion object {
        fun newInstance(): MapFragment = MapFragment()
    }

    @Inject
    @InjectPresenter
    lateinit var presenter: MapPresenter

    private var mapView: MapView? = null
    private var map: GoogleMap? = null
    private var clusterManager: ClusterManager<SixtClusterItem>? = null

    override fun getLayoutId(): Int = R.layout.fragment_map

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = super.onCreateView(inflater, container, savedInstanceState)
        mapView = v?.findViewById(R.id.f_map)
        mapView?.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mapView?.getMapAsync(this)
    }

    @SuppressLint("ResourceType")
    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        map?.uiSettings?.isZoomControlsEnabled = true
        presenter.setupDate(initCarDataDelegate?.getCars())
    }

    override fun onStart() {
        super.onStart()
        mapView?.onStart()
    }

    override fun onResume() {
        mapView?.onResume()
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView?.onPause()
    }

    override fun onStop() {
        super.onStop()
        mapView?.onStop()
    }

    override fun onLowMemory() {
        mapView?.onLowMemory()
        super.onLowMemory()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        mapView?.onSaveInstanceState(outState)
        super.onSaveInstanceState(outState)
    }

    override fun onDestroy() {
        mapView?.onDestroy()
        super.onDestroy()
    }

    override fun setupCars(cars: List<CarUIItem>?) {
        presenter.setupDate(cars)
    }

    override fun initCars(cars: List<CarUIItem>?) {
        context?.let {
            map?.let { map ->
                clusterManager = ClusterManager(it, map)
                clusterManager?.apply {
                    renderer = SixtMapClusterRenderer(it, map, this)
                    map.setOnCameraIdleListener(clusterManager)
                    map.setOnMarkerClickListener(clusterManager)
                    map.setOnCameraIdleListener(clusterManager)
                    this.setOnClusterItemClickListener { item ->
                        presenter.onMarkerClick(item.carUIItem)
                        true
                    }
                    cars?.map { addItem(SixtClusterItem(it)) }
                }
                clusterManager?.cluster()
                zoomMap(cars)
            }
        }
    }

    private fun zoomMap(cars: List<CarUIItem>?) {
        val data = LatLngBounds.builder()
        cars?.map { data.include(it.getLatLng()) }?.also {
            val width = resources.displayMetrics.widthPixels
            val height = resources.displayMetrics.heightPixels
            val padding = (width * 0.10).toInt()
            map?.animateCamera(
                CameraUpdateFactory.newLatLngBounds(data.build(), width, height, padding)
            )
        }
    }

    override fun onMarkerClick(car: CarUIItem) {
        Toast.makeText(context, car.getDescription(), Toast.LENGTH_SHORT).show()
    }

    @ProvidePresenter
    fun providePresenter(): MapPresenter = presenter
}
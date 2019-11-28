package com.sixt.test.presentation.ui.home.fragment

import android.os.Bundle
import android.view.View
import com.sixt.test.R
import com.sixt.test.common.loadImage
import com.sixt.test.data.entity.presentation.CarUIItem
import com.sixt.test.presentation.mvpview.home.fragment.CarDetailView
import com.sixt.test.presentation.presenter.home.fragment.CarDetailsPresenter
import com.sixt.test.presentation.ui.BaseFragment
import kotlinx.android.synthetic.main.fragment_car_details.*
import moxy.presenter.InjectPresenter

class CarDetailsFragment : BaseFragment(), CarDetailView {

    @InjectPresenter
    lateinit var presenter: CarDetailsPresenter

    companion object {
        private const val CAR_KEY = "car"

        fun newInstance(carUIItem: CarUIItem): CarDetailsFragment =
            CarDetailsFragment().run {
                val bundle = Bundle()
                bundle.putParcelable(CAR_KEY, carUIItem)
                arguments = bundle
                this
            }
    }

    override fun getLayoutId(): Int = R.layout.fragment_car_details

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            presenter.setupData(it.getParcelable(CAR_KEY))
        }
    }

    override fun onResume() {
        super.onResume()
        setAppBarTitle(R.string.cars_details)
        setBackButton(true)
    }

    override fun setupCar(car: CarUIItem) {
        f_car_details_image.loadImage(car.carImageUrl)
        f_car_details_modelIdentifier_value.text = car.modelIdentifier
        f_car_details_modelName_value.text = car.modelName
        f_car_details_name.text = car.name
        f_car_details_make_value.text = car.make
        f_car_details_make_group_value.text = car.group
        f_car_details_color_value.text = car.color
        f_car_details_color_value.text = car.color
        f_car_details_series_value.text = car.series
        f_car_details_fuelType_value.text = car.fuelType
        f_car_details_fuelLevel_value.text = car.fuelLevel.toString()
        f_car_details_transmission_value.text = car.transmission
        f_car_details_licensePlate_value.text = car.licensePlate
        val latLng = "${car.latitude},${car.longitude}"
        f_car_details_location_value.text = latLng
        f_car_details_innerCleanliness_value.text = car.innerCleanliness
    }
}
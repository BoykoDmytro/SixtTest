package com.sixt.test.presentation.presenter.home

import com.sixt.test.R
import com.sixt.test.data.entity.presentation.CarUIItem
import com.sixt.test.domain.usercase.items.GetCarsUseCase
import com.sixt.test.presentation.mvpview.home.IHomeView
import com.sixt.test.presentation.presenter.BasePresenter
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class HomePresenter @Inject constructor(
    private var carUseCase: GetCarsUseCase
) : BasePresenter<IHomeView>() {

    var cars: List<CarUIItem>? = null

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        getCars()
    }

    private fun getCars() {
        carUseCase.execute {
            onComplete {
                it.run {
                    this@HomePresenter.cars = it
                    viewState.updateCars(it)
                }
            }

            onError { showError(it) }

            onNetworkError { viewState.showErrorToast(R.string.no_internet_connection) }
        }
    }

    private fun showError(it: Exception) {
        val error = it.message ?: it.toString()
        viewState.showErrorToast(error)
    }
}
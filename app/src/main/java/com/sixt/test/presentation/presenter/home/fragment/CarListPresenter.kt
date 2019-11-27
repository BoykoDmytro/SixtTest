package com.sixt.test.presentation.presenter.home.fragment

import com.sixt.test.R
import com.sixt.test.data.entity.presentation.CarUIItem
import com.sixt.test.domain.usercase.items.GetCarsUseCase
import com.sixt.test.presentation.mvpview.home.fragment.CarListView
import com.sixt.test.presentation.presenter.BasePresenter
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class CarListPresenter@Inject constructor(
    private var carUseCase: GetCarsUseCase
) : BasePresenter<CarListView>() {

    fun getCars() {
        carUseCase.execute {
            onComplete { showSuccessData(it) }

            onError { showError(it) }

            onNetworkError { viewState.showErrorToast(R.string.no_internet_connection)}
        }

    }

    private fun showError(it: Exception) {
        val error = it.message ?: it.toString()
        viewState.showErrorToast(error)
    }

    private fun showSuccessData(it: List<CarUIItem>) {
        if (it.isEmpty()) {
            viewState.showEmptyView()
        } else {
            viewState.setupCars(it)
        }
    }
}
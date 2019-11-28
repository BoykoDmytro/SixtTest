package com.sixt.test.presentation.ui.home.fragment

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.sixt.test.R
import com.sixt.test.data.entity.presentation.CarUIItem
import com.sixt.test.presentation.adapters.CarListAdapter
import com.sixt.test.presentation.adapters.OnItemClickListener
import com.sixt.test.presentation.mvpview.home.fragment.CarListView
import com.sixt.test.presentation.presenter.home.fragment.CarListPresenter
import com.sixt.test.presentation.ui.listener.InitCarDataListener
import kotlinx.android.synthetic.main.fragment_car_list.*
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject

class CarListFragment : BaseSubHomeFragment(), CarListView, OnItemClickListener<CarUIItem>,
    InitCarDataListener {

    @Inject
    @InjectPresenter
    lateinit var presenter: CarListPresenter

    private val carListAdapter: CarListAdapter = CarListAdapter(this)

    companion object {
        fun newInstance(): CarListFragment = CarListFragment()
    }

    override fun getLayoutId(): Int = R.layout.fragment_car_list

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        context?.let { context ->
            f_car_list_rv.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = carListAdapter
            }
            presenter.setupData(initCarDataDelegate?.getCars())
        }
    }

    override fun initCars(cars: List<CarUIItem>) {
        carListAdapter.setItems(cars)
    }

    override fun showEmptyView() {
        f_car_list_empty_text.isVisible = true
    }

    override fun onItemClick(item: CarUIItem) {
        onItemClickListener?.onItemClick(item)
    }

    @ProvidePresenter
    fun providePresenter(): CarListPresenter = presenter

    override fun setupCars(cars: List<CarUIItem>?) {
        presenter.setupData(cars)
    }
}
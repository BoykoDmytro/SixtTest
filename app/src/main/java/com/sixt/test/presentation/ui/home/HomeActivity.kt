package com.sixt.test.presentation.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.sixt.test.R
import com.sixt.test.data.entity.presentation.CarUIItem
import com.sixt.test.presentation.adapters.OnItemClickListener
import com.sixt.test.presentation.mvpview.home.IHomeView
import com.sixt.test.presentation.presenter.home.HomePresenter
import com.sixt.test.presentation.ui.BaseActivity
import com.sixt.test.presentation.ui.home.fragment.CarDetailsFragment
import com.sixt.test.presentation.ui.home.fragment.HomeFragment
import com.sixt.test.presentation.ui.listener.InitCarDataDelegate
import com.sixt.test.presentation.ui.listener.InitCarDataListener
import kotlinx.android.synthetic.main.activity_main.*
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject

class HomeActivity : BaseActivity(), IHomeView, OnItemClickListener<CarUIItem>, InitCarDataDelegate {

    var initCarDataDelegate: MutableList<InitCarDataListener> = mutableListOf()

    companion object {
        fun startHomeActivity(context: Context): Intent = Intent(context, HomeActivity::class.java)
    }

    @Inject
    @InjectPresenter
    lateinit var presenter: HomePresenter

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(h_toolbar)
        supportFragmentManager.beginTransaction()
            .replace(R.id.home_container, HomeFragment.newInstance())
            .commit()
    }

    override fun onItemClick(item: CarUIItem) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.home_container, CarDetailsFragment.newInstance(item))
            .addToBackStack(CarDetailsFragment::class.java.simpleName)
            .commit()
    }

    override fun updateCars(cars: List<CarUIItem>) {
        initCarDataDelegate.forEach { it.setupCars(cars) }
    }

    override fun getCars(): List<CarUIItem>? = presenter.cars

    @ProvidePresenter
    fun providePresenter(): HomePresenter = presenter

}

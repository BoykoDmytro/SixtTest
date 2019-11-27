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
import com.sixt.test.presentation.ui.home.fragment.CarListFragment
import kotlinx.android.synthetic.main.activity_main.*
import moxy.presenter.InjectPresenter

class HomeActivity : BaseActivity(), IHomeView, OnItemClickListener<CarUIItem> {

    companion object {
        fun startHomeActivity(context: Context): Intent = Intent(context, HomeActivity::class.java)
    }

    @InjectPresenter
    lateinit var presenter: HomePresenter

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(h_toolbar)
        supportFragmentManager.beginTransaction()
            .replace(R.id.home_container, CarListFragment.newInstance())
            .commit()
    }

    override fun onItemClick(item: CarUIItem) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.home_container, CarListFragment.newInstance())
            .commit()
    }
}

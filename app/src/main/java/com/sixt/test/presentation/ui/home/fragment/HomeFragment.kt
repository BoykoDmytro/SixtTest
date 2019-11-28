package com.sixt.test.presentation.ui.home.fragment

import android.os.Bundle
import android.view.View
import com.sixt.test.R
import com.sixt.test.presentation.adapters.HomeVPAdapter
import com.sixt.test.presentation.mvpview.home.fragment.HomeFragmentView
import com.sixt.test.presentation.presenter.home.fragment.HomeFragmentPresenter
import com.sixt.test.presentation.ui.BaseFragment
import kotlinx.android.synthetic.main.fragment_home.*
import moxy.presenter.InjectPresenter

class HomeFragment : BaseFragment(), HomeFragmentView {

    companion object {
        fun newInstance(): HomeFragment = HomeFragment()
    }

    override fun getLayoutId(): Int = R.layout.fragment_home

    private lateinit var adapter: HomeVPAdapter

    @InjectPresenter
    lateinit var presenter: HomeFragmentPresenter

    override fun onResume() {
        super.onResume()
        setAppBarTitle(R.string.home)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        context?.let {
            adapter = HomeVPAdapter(it, childFragmentManager)
            f_home_viewpager.adapter = adapter
            f_home_tabs.setupWithViewPager(f_home_viewpager)
        }
    }
}
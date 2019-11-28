package com.sixt.test.presentation.ui.home.fragment

import android.content.Context
import com.sixt.test.data.entity.presentation.CarUIItem
import com.sixt.test.presentation.adapters.OnItemClickListener
import com.sixt.test.presentation.ui.BaseFragment
import com.sixt.test.presentation.ui.home.HomeActivity
import com.sixt.test.presentation.ui.listener.InitCarDataDelegate
import com.sixt.test.presentation.ui.listener.InitCarDataListener

abstract class BaseSubHomeFragment : BaseFragment(), InitCarDataListener {

    protected var onItemClickListener: OnItemClickListener<CarUIItem>? = null
    protected var initCarDataDelegate: InitCarDataDelegate? = null

    @Suppress("UNCHECKED_CAST")
    override fun onAttach(context: Context) {
        super.onAttach(context)
        onItemClickListener = context as? OnItemClickListener<CarUIItem>
        initCarDataDelegate = context as? InitCarDataDelegate
        (context as? HomeActivity)?.initCarDataDelegate?.add(this)
    }

}
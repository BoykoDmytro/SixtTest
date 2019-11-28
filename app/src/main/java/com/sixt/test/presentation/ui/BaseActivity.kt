package com.sixt.test.presentation.ui

import android.os.Bundle
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.appcompat.widget.Toolbar
import com.sixt.test.presentation.mvpview.IBaseMvpView
import dagger.android.support.DaggerAppCompatActivity
import moxy.MvpDelegate

abstract class BaseActivity : DaggerAppCompatActivity(), IBaseMvpView {

    private var mvpDelegate: MvpDelegate<out BaseActivity>? = null

    private var toolbar: Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        getMvpDelegate().onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        getMvpDelegate().onAttach()
    }

    override fun onResume() {
        super.onResume()
        getMvpDelegate().onAttach()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        getMvpDelegate().onSaveInstanceState(outState)
        getMvpDelegate().onDetach()
    }

    override fun onStop() {
        super.onStop()
        getMvpDelegate().onDetach()
    }

    override fun onDestroy() {
        super.onDestroy()
        getMvpDelegate().onDestroyView()
        if (isFinishing) getMvpDelegate().onDestroy()
    }

    override fun setSupportActionBar(toolbar: Toolbar?) {
        this.toolbar = toolbar
        super.setSupportActionBar(toolbar)
    }

    @LayoutRes
    abstract fun getLayoutId(): Int

    override fun showProgressDialog() {}

    override fun hideProgressDialog() {}

    override fun showErrorToast(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }

    override fun showErrorToast(resId: Int) {
        showErrorToast(getString(resId))
    }

    fun setBackButton(isEnabled: Boolean) {
        supportActionBar?.setDisplayHomeAsUpEnabled(isEnabled)
        supportActionBar?.setDisplayShowHomeEnabled(isEnabled)
        if (isEnabled) toolbar?.setNavigationOnClickListener { onBackPressed() }
        else toolbar?.setNavigationOnClickListener(null)
    }

    fun setAppBarTitle(@StringRes titleResId: Int) {
        supportActionBar?.setTitle(titleResId)
    }

    fun setAppBarTitle(title: String) {
        supportActionBar?.title = title
    }

    fun getMvpDelegate(): MvpDelegate<*> {
        if (mvpDelegate == null) {
            mvpDelegate = MvpDelegate(this)
        }
        return mvpDelegate!!
    }
}
package com.sixt.test.presentation.ui.splash

import com.sixt.test.R
import com.sixt.test.presentation.mvpview.splash.SplashView
import com.sixt.test.presentation.presenter.splash.SplashPresenter
import com.sixt.test.presentation.ui.BaseActivity
import com.sixt.test.presentation.ui.home.HomeActivity
import kotlinx.android.synthetic.main.activity_splash.*
import moxy.presenter.InjectPresenter

class SplashActivity : BaseActivity(), SplashView {

    companion object {
        const val SPLASH_DELAY = 300L
    }

    @InjectPresenter
    lateinit var splashPresenter: SplashPresenter

    override fun getLayoutId(): Int = R.layout.activity_splash

    override fun navigateToHome() {
        a_splash_icon.postDelayed(::startHome, SPLASH_DELAY)
    }

    private fun startHome() {
        startActivity(HomeActivity.startHomeActivity(this))
        finish()
    }
}
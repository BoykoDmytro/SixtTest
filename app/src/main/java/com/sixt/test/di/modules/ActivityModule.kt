package com.sixt.test.di.modules

import com.sixt.test.di.providers.HomeActivityProviders
import com.sixt.test.presentation.ui.home.HomeActivity
import com.sixt.test.presentation.ui.splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector()
    abstract fun bindSplashActivity(): SplashActivity

    @ContributesAndroidInjector(modules = [HomeActivityProviders::class])
    abstract fun bindMainActivity(): HomeActivity
}
package com.sixt.test.di.providers

import com.sixt.test.presentation.ui.home.fragment.CarDetailsFragment
import com.sixt.test.presentation.ui.home.fragment.CarListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class HomeActivityProviders {

    @ContributesAndroidInjector
    abstract fun provideCarListFragment(): CarListFragment

    @ContributesAndroidInjector
    abstract fun provideCarDetailsFragment(): CarDetailsFragment
}
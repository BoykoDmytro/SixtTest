package com.sixt.test.di.providers

import com.sixt.test.presentation.ui.home.fragment.CarDetailsFragment
import com.sixt.test.presentation.ui.home.fragment.CarListFragment
import com.sixt.test.presentation.ui.home.fragment.HomeFragment
import com.sixt.test.presentation.ui.home.fragment.MapFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class HomeActivityProviders {

    @ContributesAndroidInjector
    abstract fun provideCarListFragment(): CarListFragment

    @ContributesAndroidInjector
    abstract fun provideCarDetailsFragment(): CarDetailsFragment

    @ContributesAndroidInjector
    abstract fun provideHomeFragment(): HomeFragment

    @ContributesAndroidInjector
    abstract fun provideMapFragment(): MapFragment
}
package com.sixt.test.di

import android.app.Application
import android.content.Context
import com.sixt.test.SixtApp
import com.sixt.test.di.modules.ActivityModule
import com.sixt.test.di.modules.ApplicationModule
import com.sixt.test.di.modules.NetworkModule
import com.sixt.test.di.modules.RepositoryModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class, ApplicationModule::class, ActivityModule::class,
        NetworkModule::class, RepositoryModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<SixtApp> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun context(): Context
}
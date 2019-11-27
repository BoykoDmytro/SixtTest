package com.sixt.test.di.modules

import com.sixt.test.data.repository.CarsRepository
import com.sixt.test.domain.repository.ICarRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindsItemsRepository(repository: CarsRepository): ICarRepository
}
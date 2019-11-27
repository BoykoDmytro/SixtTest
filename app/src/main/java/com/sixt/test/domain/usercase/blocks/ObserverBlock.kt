package com.sixt.test.domain.usercase.blocks

import com.sixt.test.domain.usercase.BaseObserveCoroutinesUseCase

typealias ObserverBlock<T> = BaseObserveCoroutinesUseCase.Request<T>.() -> Unit
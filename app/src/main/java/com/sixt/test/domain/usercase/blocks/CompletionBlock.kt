package com.sixt.test.domain.usercase.blocks

import com.sixt.test.domain.usercase.BaseCoroutinesUseCase

typealias CompletionBlock<T> = BaseCoroutinesUseCase.Request<T>.() -> Unit
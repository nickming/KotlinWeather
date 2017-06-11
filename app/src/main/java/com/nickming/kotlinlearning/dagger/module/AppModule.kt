package com.nickming.kotlinlearning.dagger.module

import android.content.Context
import dagger.Module
import dagger.Provides

/**
 * class description here
 * @author nickming
 * @version 1.0.0
 * @since 2017-06-10 下午4:05
 * Copyright (c) 2017 nickming All right reserved.
 */
@Module
class AppModule(private val context:Context) {

    @Provides fun provideContext():Context=context
}
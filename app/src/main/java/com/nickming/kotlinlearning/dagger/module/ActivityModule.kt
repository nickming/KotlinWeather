package com.nickming.kotlinlearning.dagger.module

import com.nickming.kotlinlearning.ui.weather.WeatherContract
import dagger.Module
import dagger.Provides

/**
 * class description here
 * @author nickming
 * @version 1.0.0
 * @since 2017-06-11 下午3:35
 * Copyright (c) 2017 nickming All right reserved.
 */
@Module
class ActivityModule(private val mView: WeatherContract.View) {
    @Provides fun getView() = mView
}
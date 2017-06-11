package com.nickming.kotlinlearning.dagger.component

import com.nickming.kotlinlearning.dagger.module.ActivityModule
import com.nickming.kotlinlearning.ui.weather.WeatherActivity
import dagger.Subcomponent

/**
 * class description here
 * @author nickming
 * @version 1.0.0
 * @since 2017-06-11 下午3:23
 * Copyright (c) 2017 nickming All right reserved.
 */
@Subcomponent(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {
    fun inject(activity: WeatherActivity)
}

package com.nickming.kotlinlearning.dagger.component

import com.nickming.kotlinlearning.base.App
import com.nickming.kotlinlearning.dagger.module.ActivityModule
import com.nickming.kotlinlearning.dagger.module.ApiModule
import dagger.Component

/**
 * class description here
 * @author nickming
 * @version 1.0.0
 * @since 2017-06-10 下午4:01
 * Copyright (c) 2017 nickming All right reserved.
 */
@Component(modules = arrayOf(ApiModule::class))
interface ApiComponent {
    fun inject(app: App)

    fun plus(module: ActivityModule): ActivityComponent
}
package com.nickming.kotlinlearning.base

import android.app.Application
import com.nickming.kotlinlearning.dagger.component.ApiComponent
import com.nickming.kotlinlearning.dagger.component.DaggerApiComponent
import com.nickming.kotlinlearning.dagger.module.ApiModule
import com.nickming.kotlinlearning.dagger.module.AppModule
import javax.inject.Inject

/**
 * class description here
 * @author nickming
 * @version 1.0.0
 * @since 2017-06-09 下午7:05
 * Copyright (c) 2017 nickming All right reserved.
 */

class App : Application() {
    init {
        instance = this
    }

    @Inject lateinit var apiComponent: ApiComponent
    override fun onCreate() {
        super.onCreate()
        DaggerApiComponent.builder().apiModule(ApiModule()).appModule(AppModule(this)).build().inject(this)
    }


    companion object {
        lateinit var instance: App

    }
}

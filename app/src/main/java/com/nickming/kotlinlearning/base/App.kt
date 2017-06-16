package com.nickming.kotlinlearning.base

import android.app.Activity
import android.app.Application
import android.os.Bundle
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

class App : Application(), Application.ActivityLifecycleCallbacks {

    lateinit var mActivityLists: MutableList<Activity>

    init {
        instance = this
    }

    @Inject lateinit var apiComponent: ApiComponent
    override fun onCreate() {
        super.onCreate()
        mActivityLists = ArrayList()
        DaggerApiComponent.builder().apiModule(ApiModule()).appModule(AppModule(this)).build().inject(this)
    }


    companion object {
        lateinit var instance: App
    }

    /**
     * 结束所有activity
     */
    fun finishAllActivities() {
        mActivityLists.forEach {
            item ->
            item.finish()
        }
    }

    override fun onActivityPaused(activity: Activity?) {

    }

    override fun onActivityResumed(activity: Activity?) {

    }

    override fun onActivityStarted(activity: Activity?) {

    }

    override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {

    }

    override fun onActivityStopped(activity: Activity?) {

    }

    override fun onActivityDestroyed(activity: Activity?) {
        mActivityLists.remove(activity)
    }

    override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {
        mActivityLists.add(activity!!)
    }
}

package com.nickming.kotlinlearning.ui.weather

import com.nickming.kotlinlearning.base.BasePresenter
import com.nickming.kotlinlearning.util.LogUtil
import rx.android.schedulers.AndroidSchedulers
import javax.inject.Inject

/**
 * class description here
 * @author nickming
 * @version 1.0.0
 * @since 2017-06-11 下午3:44
 * Copyright (c) 2017 nickming All right reserved.
 */
class WeatherPresenter
@Inject constructor(private val model: WeatherModel, private val view: WeatherContract.View) : WeatherContract.Presetner, BasePresenter() {
    override fun getWeatherData(city: String) {
        subscribe(model.getWeatherData(city).observeOn(AndroidSchedulers.mainThread()).subscribe({
            res ->
            if (res != null) {
                view.setWeatherData(res.getWeaetherData())
            }
        }, {
            err ->
            LogUtil.e("error", err.message!!)
        }))
    }

}
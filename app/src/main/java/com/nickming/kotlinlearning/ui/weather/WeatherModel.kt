package com.nickming.kotlinlearning.ui.weather

import com.nickming.kotlinlearning.api.WeatherApi
import com.nickming.kotlinlearning.base.Constants
import com.nickming.kotlinlearning.bean.JsonResult
import rx.Observable
import javax.inject.Inject

/**
 * class description here
 * @author nickming
 * @version 1.0.0
 * @since 2017-06-11 下午3:42
 * Copyright (c) 2017 nickming All right reserved.
 */
class WeatherModel
@Inject constructor(private val api: WeatherApi) : WeatherContract.Model {
    override fun getWeatherData(city: String): Observable<JsonResult> {
        return api.fetchWeatherData(city, Constants.WEATHER_API_KEY)
    }
}

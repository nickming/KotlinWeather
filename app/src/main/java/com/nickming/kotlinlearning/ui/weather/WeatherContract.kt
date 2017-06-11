package com.nickming.kotlinlearning.ui.weather

import com.nickming.kotlinlearning.bean.JsonResult
import com.nickming.kotlinlearning.bean.Weather
import rx.Observable

/**
 * class description here
 * @author nickming
 * @version 1.0.0
 * @since 2017-06-11 下午3:37
 * Copyright (c) 2017 nickming All right reserved.
 */
interface WeatherContract {

    interface View {
        fun setWeatherData(weather: Weather)

        fun changeBackgroundColor(color:Int)
    }

    interface Model {
        fun getWeatherData(city: String): Observable<JsonResult>
    }

    interface Presetner {
        fun getWeatherData(city: String)
    }
}
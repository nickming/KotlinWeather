package com.nickming.kotlinlearning.api

import com.nickming.kotlinlearning.bean.JsonResult
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

/**
 * class description here
 * @author nickming
 * @version 1.0.0
 * @since 2017-06-10 下午3:46
 * Copyright (c) 2017 nickming All right reserved.
 */
interface WeatherApi {

    @GET("v5/weather")
    fun fetchWeatherData(@Query("city") city: String,@Query("key") key:String): Observable<JsonResult>
}
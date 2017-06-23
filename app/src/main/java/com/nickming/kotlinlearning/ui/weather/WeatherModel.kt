package com.nickming.kotlinlearning.ui.weather

import com.baidu.location.BDLocation
import com.baidu.location.BDLocationListener
import com.baidu.location.LocationClient
import com.nickming.kotlinlearning.api.WeatherApi
import com.nickming.kotlinlearning.base.Constants
import com.nickming.kotlinlearning.bean.JsonResult
import rx.Observable
import rx.schedulers.Schedulers
import javax.inject.Inject

/**
 * class description here
 * @author nickming
 * @version 1.0.0
 * @since 2017-06-11 下午3:42
 * Copyright (c) 2017 nickming All right reserved.
 */
class WeatherModel
@Inject constructor(private val api: WeatherApi, private val locationClient: LocationClient) : WeatherContract.Model {
    override fun getLocationData(): Observable<BDLocation> {
        return Observable.create<BDLocation> {
            subscriber ->
            locationClient.registerLocationListener(object : BDLocationListener {
                override fun onReceiveLocation(p0: BDLocation?) {
                    subscriber.onNext(p0)
                    subscriber.onCompleted()
                }

                override fun onConnectHotSpotMessage(p0: String?, p1: Int) {
                    subscriber.onError(Throwable(p0))
                }
            })
            locationClient.start()
        }.subscribeOn(Schedulers.io())
    }

    override fun getWeatherData(city: String): Observable<JsonResult> {
        return api.fetchWeatherData(city, Constants.WEATHER_API_KEY)
    }
}

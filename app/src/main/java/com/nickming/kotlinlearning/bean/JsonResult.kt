package com.nickming.kotlinlearning.bean

/**
 * class description here
 * @author nickming
 * @version 1.0.0
 * @since 2017-06-11 下午7:46
 * Copyright (c) 2017 nickming All right reserved.
 */
class JsonResult(val HeWeather5: List<Weather>) {

    fun getWeaetherData(): Weather = HeWeather5.get(0)
}
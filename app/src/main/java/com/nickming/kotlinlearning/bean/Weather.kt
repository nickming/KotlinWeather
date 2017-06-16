package com.nickming.kotlinlearning.bean

/**
 * class description here
 * @author nickming
 * @version 1.0.0
 * @since 2017-06-11 上午10:54
 * Copyright (c) 2017 nickming All right reserved.
 */
class Weather(val basic: Basic, val now: Now, val daily_forecast: List<DailyItem>) {

    class Basic(val city: String, val cnty: String)

    class DailyItem(val tmp: Tmp, val date: String,val cond: DailyCond) {
        class Tmp(val max: String, val min: String)
        class DailyCond(val code_d: Int, val code_n: Int, val txt_d: String, val txt_n: String)
    }

    class Now(val cond: Cond, val hum: String, val vis: String, val pres: String, val tmp: String)

    class Cond(val code: Int, val txt: String)
}
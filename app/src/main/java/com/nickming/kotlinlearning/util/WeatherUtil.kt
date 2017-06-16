package com.nickming.kotlinlearning.util

import com.nickming.kotlinlearning.R
import java.text.ParsePosition
import java.text.SimpleDateFormat
import java.util.*

/**
 * class description here

 * @author nickming
 * *
 * @version 1.0.0
 * *
 * @since 2017-06-15 上午10:54
 * * Copyright (c) 2017 nickming All right reserved.
 */

object WeatherUtil {

    fun convertCodeToRes(code: Int): Int {
        when (code) {
            100 -> return R.drawable.ic_100
            101, 102 -> return R.drawable.ic_101
            103, 104 -> return R.drawable.ic_103
            in 200..213 -> return R.drawable.ic_209
            in 300..303 -> return R.drawable.ic_302
            304 -> return R.drawable.ic_304
            305 -> return R.drawable.ic_305
            306 -> return R.drawable.ic_306
            in 307..309 -> return R.drawable.ic_307
            in 310..313 -> return R.drawable.ic_310
            400 -> return R.drawable.ic_400
            401 -> return R.drawable.ic_401
            402 -> return R.drawable.ic_402
            403 -> return R.drawable.ic_403
            in 404..407 -> return R.drawable.ic_404
            501 -> return R.drawable.ic_501
            502 -> return R.drawable.ic_502
            503, 504 -> return R.drawable.ic_503
            507, 508 -> return R.drawable.ic_507
            else -> return R.drawable.ic_100
        }
    }

    fun addSuffix(content: String): String {
        return content + "°C"
    }

    fun judgeDayOrNight(): Boolean {
        var now: Date = Date()
        return now.hours > 0 && now.hours < 18
    }

    fun convertDateToWeekday(date: String): String {
        var sdf = SimpleDateFormat("yyyy-MM-dd")
        var parse = ParsePosition(0)
        var realDate = sdf.parse(date, parse)
        var calendar = Calendar.getInstance()
        calendar.time = realDate
        return SimpleDateFormat("EEEE").format(calendar.time)
    }

}

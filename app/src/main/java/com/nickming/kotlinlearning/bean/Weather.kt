package com.nickming.kotlinlearning.bean

/**
 * class description here
 * @author nickming
 * @version 1.0.0
 * @since 2017-06-11 上午10:54
 * Copyright (c) 2017 nickming All right reserved.
 */
class Weather(val basic: Basic) {

    class Basic(val city: String,
                val cnty: String) {
    }
}
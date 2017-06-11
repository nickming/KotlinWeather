package com.nickming.kotlinlearning.util

import android.util.Log

/**
 * class description here
 * @author nickming
 * @version 1.0.0
 * @since 2017-06-11 下午5:54
 * Copyright (c) 2017 nickming All right reserved.
 */
class LogUtil {
    companion object {

        const val VERBOSE = 1
        const val DEBUG = 2
        const val INFO = 3
        const val WARN = 4
        const val ERROR = 5
        const val NOTHING = 6
        var level: Int = VERBOSE

        fun v(tag: String, msg: String) {
            if (level <= VERBOSE)
                Log.v(tag, msg)
        }

        fun d(tag: String, msg: String) {
            if (level <= DEBUG)
                Log.d(tag, msg)
        }

        fun i(tag: String, msg: String) {
            if (level <= INFO)
                Log.i(tag, msg)
        }

        fun w(tag: String, msg: String) {
            if (level <= WARN)
                Log.w(tag, msg)
        }

        fun e(tag: String, msg: String) {
            if (level <= ERROR)
                Log.e(tag, msg)
        }

    }
}

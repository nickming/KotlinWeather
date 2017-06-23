package com.nickming.kotlinlearning.ui.weather

import android.app.AlarmManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.IBinder
import android.os.SystemClock
import javax.inject.Inject

/**
 * class description here
 * @author nickming
 * @version 1.0.0
 * @since 2017-06-24 上午12:09
 * Copyright (c) 2017 nickming All right reserved.
 */
class WeatherUpdateService : Service() {

    @Inject lateinit var mPresenter: WeatherPresenter

    override fun onBind(intent: Intent?): IBinder {
        return null!!
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        updateWeather()
        var manager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        var anHour = 8 * 60 * 60 * 1000
        var triggerAtTime = SystemClock.elapsedRealtime() + anHour
        var intent = Intent(this, WeatherUpdateService::class.java)
        var pendingIntent = PendingIntent.getService(this, 0, intent, 0)
        manager.cancel(pendingIntent)
        manager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, triggerAtTime, pendingIntent)
        return super.onStartCommand(intent, flags, startId)
    }

    fun updateWeather(): Unit {
        mPresenter.getWeatherData("dongguan")
    }
}
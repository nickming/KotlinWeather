package com.nickming.kotlinlearning.ui.splash

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.nickming.kotlinlearning.R
import com.nickming.kotlinlearning.ui.weather.WeatherActivity
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        welcomeTv.postDelayed({
            var intent = Intent(this, WeatherActivity::class.java)
            startActivity(intent)
        }, 1500)


    }
}

package com.nickming.kotlinlearning.ui.weather

import android.databinding.DataBindingUtil
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import com.nickming.kotlinlearning.R
import com.nickming.kotlinlearning.base.BaseActivity
import com.nickming.kotlinlearning.base.getMainComponent
import com.nickming.kotlinlearning.bean.Weather
import com.nickming.kotlinlearning.dagger.module.ActivityModule
import com.nickming.kotlinlearning.databinding.ActivityWeatherBinding
import com.nickming.kotlinlearning.util.LogUtil
import kotlinx.android.synthetic.main.activity_weather.*
import javax.inject.Inject

class WeatherActivity : BaseActivity<ActivityWeatherBinding>(), WeatherContract.View {


    @Inject lateinit var mPresenter: WeatherPresenter

    override fun createDataBinding(savedInstanceState: Bundle?): ActivityWeatherBinding {
        return DataBindingUtil.setContentView(this, R.layout.activity_weather)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun initView() {
        getMainComponent().plus(ActivityModule(this)).inject(this)
        mPresenter.getWeatherData("dongguan")
        weatherRootWrapper.setBackgroundColor(getColor(R.color.blue))
    }

    override fun changeBackgroundColor(color: Int) {

    }

    override fun setWeatherData(weather: Weather) {
        LogUtil.i("tag", weather.basic.city)
        mDataBinding.weather = weather
    }


}

package com.nickming.kotlinlearning.ui.weather

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.nickming.kotlinlearning.base.BaseFragment
import com.nickming.kotlinlearning.bean.Weather
import com.nickming.kotlinlearning.databinding.FragmentWeatherDetailBinding
import com.nickming.kotlinlearning.util.WeatherUtil
import kotlinx.android.synthetic.main.fragment_weather_detail.*

/**
 * class description here
 * @author nickming
 * @version 1.0.0
 * @since 2017-06-12 上午1:57
 * Copyright (c) 2017 nickming All right reserved.
 */
class CityWeatherFragment : BaseFragment<FragmentWeatherDetailBinding>() {

    lateinit var title: String

    fun refreshWeather(weather: Weather) {
        mDataBinding.weather = weather
        weatherDetailCondIv.setImageResource(WeatherUtil.convertCodeToRes(weather.now.cond.code))
    }

    override fun initView() {

    }

    override fun createDataBinding(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): FragmentWeatherDetailBinding {
        return FragmentWeatherDetailBinding.inflate(inflater, container, false)
    }

    companion object {
        fun newInstance(cityName: String): CityWeatherFragment {
            val fragment = CityWeatherFragment()
            fragment.title = cityName
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }
}
package com.nickming.kotlinlearning.ui.weather

import android.databinding.DataBindingUtil
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v7.widget.StaggeredGridLayoutManager
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
    lateinit var mFragments: MutableList<CityWeatherFragment>
    lateinit var mAdapter: FragmentStatePagerAdapter
    lateinit var mWeatherAdapter: WeatherAdapter

    override fun createDataBinding(savedInstanceState: Bundle?): ActivityWeatherBinding {
        return DataBindingUtil.setContentView(this, R.layout.activity_weather)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun initView() {
        getMainComponent().plus(ActivityModule(this)).inject(this)
        mPresenter.getWeatherData("dongguan")
        weatherRootWrapper.setBackgroundColor(getColor(R.color.blue))
        initFragments()
        mAdapter = object : FragmentStatePagerAdapter(supportFragmentManager) {
            override fun getItem(position: Int): Fragment {
                return mFragments.get(position)
            }

            override fun getCount(): Int {
                return mFragments.size
            }
        }
        weatherViewPager.adapter = mAdapter
    }

    private fun initFragments() {
        mFragments = mutableListOf()
        mFragments.add(CityWeatherFragment.newInstance("dongguan"))
    }

    private fun initRecyclerView(datas: List<Weather.DailyItem>) {
        mWeatherAdapter = WeatherAdapter(datas)
        forecastRv.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)
        forecastRv.adapter = mWeatherAdapter
    }


    override fun changeBackgroundColor(color: Int) {

    }

    override fun setWeatherData(weather: Weather) {
        LogUtil.i("tag", weather.basic.city)
        mDataBinding.weather = weather
        mFragments.get(0).refreshWeather(weather)
        initRecyclerView(weather.daily_forecast)
    }

}

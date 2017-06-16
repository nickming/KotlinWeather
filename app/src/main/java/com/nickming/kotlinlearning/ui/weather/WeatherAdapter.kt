package com.nickming.kotlinlearning.ui.weather

import android.widget.ImageView
import android.widget.TextView
import com.nickming.kotlinlearning.BR
import com.nickming.kotlinlearning.R
import com.nickming.kotlinlearning.bean.Weather
import com.nickming.kotlinlearning.util.WeatherUtil
import com.nickming.kotlinlearning.widget.adapter.BaseDatabindingAdapter
import com.nickming.kotlinlearning.widget.adapter.BaseDatabindingViewHolder

/**
 * class description here
 * @author nickming
 * @version 1.0.0
 * @since 2017-06-15 下午5:05
 * Copyright (c) 2017 nickming All right reserved.
 */
class WeatherAdapter(private var mList: List<Weather.DailyItem>) : BaseDatabindingAdapter<Weather.DailyItem>(mList, R.layout.item_weather_forecast, BR.daily) {

    override fun onBindViewHolder(holder: BaseDatabindingViewHolder?, position: Int) {
        super.onBindViewHolder(holder, position)
        with(holder!!) {
            var image: ImageView = holder.itemView.findViewById(R.id.weatherForecastIv) as ImageView
            var date = holder.itemView.findViewById(R.id.weatherForecastDateTv) as TextView
            var tmp = holder.itemView.findViewById(R.id.weatherForecastTmpTv) as TextView
            date.text = WeatherUtil.convertDateToWeekday(mList.get(position).date)
            tmp.text = WeatherUtil.addSuffix(mList.get(position).tmp.min + "~" + mList.get(position).tmp.max)
            if (WeatherUtil.judgeDayOrNight()) {
                image.setImageResource(WeatherUtil.convertCodeToRes(mList.get(position).cond.code_d))
            } else {
                image.setImageResource(WeatherUtil.convertCodeToRes(mList.get(position).cond.code_n))
            }

        }
    }
}
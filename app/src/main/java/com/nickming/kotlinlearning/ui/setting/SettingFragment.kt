package com.nickming.kotlinlearning.ui.setting

import android.content.SharedPreferences
import android.os.Bundle
import android.preference.Preference
import android.preference.PreferenceFragment
import com.nickming.kotlinlearning.R
import com.nickming.kotlinlearning.base.Constants


/**
 * class description here
 * @author nickming
 * @version 1.0.0
 * @since 2017-06-24 上午11:34
 * Copyright (c) 2017 nickming All right reserved.
 */
class SettingFragment : PreferenceFragment(), SharedPreferences.OnSharedPreferenceChangeListener {

    lateinit var mWeatherRefresh: Preference
    lateinit var mWeatherTheme: Preference
    lateinit var mClearCache: Preference
    lateinit var mSp: SharedPreferences

    companion object {
        fun newInstance(): SettingFragment {
            val args = Bundle()
            val fragment = SettingFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addPreferencesFromResource(R.xml.setting_preference)
        initSharedPreferences()
        initListeners()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mSp = preferenceScreen.sharedPreferences
        mSp.registerOnSharedPreferenceChangeListener(this)
    }

    /**
     * 初始化控件绑定
     */
    fun initSharedPreferences() {
        mWeatherRefresh = preferenceManager.findPreference(Constants.WEATHER_SP_REFRESH)
        mClearCache = preferenceManager.findPreference(Constants.WEATHER_SP_CLEAR_CACHE)
        mWeatherTheme = preferenceManager.findPreference(Constants.WEATHER_SP_THEME)
    }

    fun initListeners() {
        mWeatherTheme.setOnPreferenceClickListener {
            preference ->
            false
        }
        mClearCache.setOnPreferenceClickListener {
            preference ->
            false
        }
        mWeatherTheme.setOnPreferenceClickListener {
            preference ->
            false
        }
    }

    override fun onDestroy() {
        mSp.unregisterOnSharedPreferenceChangeListener(this)
        super.onDestroy()
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?) {
        when (key) {
            Constants.WEATHER_SP_CLEAR_CACHE -> {
            }
            Constants.WEATHER_SP_REFRESH -> {
            }
            Constants.WEATHER_SP_THEME -> {
            }
        }
    }
}
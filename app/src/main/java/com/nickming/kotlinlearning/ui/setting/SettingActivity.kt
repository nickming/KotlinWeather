package com.nickming.kotlinlearning.ui.setting

import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import com.nickming.kotlinlearning.R
import kotlinx.android.synthetic.main.activity_setting.*

class SettingActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        var fragment = fragmentManager.findFragmentById(R.id.settingLayout)
        if (fragment == null) {
            fragment = SettingFragment.newInstance()
            val ft = fragmentManager.beginTransaction()
            ft.add(R.id.settingLayout, fragment)
            ft.commit()
        }

        settingToolbar.title = "设置"
        settingToolbar.setTitleTextColor(getColor(R.color.white))
        setSupportActionBar(settingToolbar)
        settingToolbar.setNavigationOnClickListener { v -> finish() }
    }
}

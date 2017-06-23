package com.nickming.kotlinlearning.ui.splash

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.nickming.kotlinlearning.R
import com.nickming.kotlinlearning.base.toast
import com.nickming.kotlinlearning.ui.weather.WeatherActivity
import com.tbruyelle.rxpermissions.Permission
import com.tbruyelle.rxpermissions.RxPermissions
import kotlinx.android.synthetic.main.activity_splash.*
import rx.Observer

class SplashActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        var permission = RxPermissions(this)
        permission.requestEach(Manifest.permission.READ_PHONE_STATE, Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .subscribe(object : Observer<Permission> {
                    override fun onNext(t: Permission?) {
                        if (t != null) {
                            if (t.granted) {
                            } else if (t.shouldShowRequestPermissionRationale) {
                                toast("请给予权限:" + t.name)
                            } else {
                                toast("请给予权限" + t.name)
                            }
                        }
                    }

                    override fun onCompleted() {
                        welcomeTv.postDelayed({
                            var intent = Intent(this@SplashActivity, WeatherActivity::class.java)
                            startActivity(intent)
                            finish()
                        }, 1500)
                    }

                    override fun onError(e: Throwable?) {

                    }

                })
    }

}


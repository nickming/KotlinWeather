package com.nickming.kotlinlearning.base

import android.content.Context
import android.widget.Toast

/**
 * class description here
 * @author nickming
 * @version 1.0.0
 * @since 2017-06-11 下午12:21
 * Copyright (c) 2017 nickming All right reserved.
 */

fun Context.getMainComponent()=App.instance.apiComponent

fun Context.toast(msg:String){
    Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
}
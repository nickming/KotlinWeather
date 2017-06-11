package com.nickming.kotlinlearning.base

import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * class description here
 * @author nickming
 * @version 1.0.0
 * @since 2017-06-09 下午7:11
 * Copyright (c) 2017 nickming All right reserved.
 */
abstract class BaseActivity<B : ViewDataBinding>:AppCompatActivity(){

    protected lateinit var mDataBinding:B

    abstract fun createDataBinding(savedInstanceState: Bundle?):B

    abstract fun initView()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mDataBinding=createDataBinding(savedInstanceState)
        initView()
    }
}
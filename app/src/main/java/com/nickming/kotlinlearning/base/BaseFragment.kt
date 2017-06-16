package com.nickming.kotlinlearning.base

import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * class description here
 * @author nickming
 * @version 1.0.0
 * @since 2017-06-12 上午2:03
 * Copyright (c) 2017 nickming All right reserved.
 */
abstract class BaseFragment<B : ViewDataBinding>: Fragment() {

    protected lateinit var mDataBinding:B

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mDataBinding=createDataBinding(inflater,container,savedInstanceState)
        initView()
        return mDataBinding.root
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    abstract fun  createDataBinding(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): B

    abstract fun initView()
}
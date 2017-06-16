package com.nickming.kotlinlearning.widget.adapter

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView

/**
 * class description here
 * @author nickming
 * @version 1.0.0
 * @since 2017-06-15 下午12:37
 * Copyright (c) 2017 nickming All right reserved.
 */
class BaseDatabindingViewHolder(var viewDataBinding: ViewDataBinding) : RecyclerView.ViewHolder(viewDataBinding.root) {
}
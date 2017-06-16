package com.nickming.kotlinlearning.widget.adapter

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * class description here
 * @author nickming
 * @version 1.0.0
 * @since 2017-06-15 下午12:38
 * Copyright (c) 2017 nickming All right reserved.
 */
open class BaseDatabindingAdapter<T>(var list: List<T>, val layoutId: Int, val variableId: Int) : RecyclerView.Adapter<BaseDatabindingViewHolder>() {

    var mListener: ((position: Int) -> Unit)? = null

    override fun onBindViewHolder(holder: BaseDatabindingViewHolder?, position: Int) {
        with(holder!!) {
            holder.viewDataBinding.setVariable(variableId, list[position])
            holder.viewDataBinding.executePendingBindings()
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BaseDatabindingViewHolder {
        var inflater: LayoutInflater = LayoutInflater.from(parent!!.context)
        var binding: ViewDataBinding = DataBindingUtil.inflate(inflater, layoutId, parent, false)
        var vh: BaseDatabindingViewHolder = BaseDatabindingViewHolder(binding)
        return vh
    }

    fun setOnItemClickListener(listener: (pos: Int) -> Unit) {
        this.mListener = listener
    }


}
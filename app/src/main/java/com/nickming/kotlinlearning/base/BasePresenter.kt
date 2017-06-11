package com.nickming.kotlinlearning.base

import rx.Subscription
import rx.subscriptions.CompositeSubscription

/**
 * class description here
 * @author nickming
 * @version 1.0.0
 * @since 2017-06-11 上午11:14
 * Copyright (c) 2017 nickming All right reserved.
 */
open class BasePresenter {


    var compositeSubscription = CompositeSubscription()

    fun subscribe(subscription: Subscription) {
        compositeSubscription.add(subscription)
    }

    fun unSubscribe() {
        if (compositeSubscription.hasSubscriptions()) {
            compositeSubscription.unsubscribe()
        }
    }

}
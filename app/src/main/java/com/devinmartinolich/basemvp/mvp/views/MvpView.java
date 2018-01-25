package com.devinmartinolich.basemvp.mvp.views;

import android.content.Context;

import com.devinmartinolich.basemvp.framework.utils.network.NetworkRetryCallback;

/**
 * Name : MvpView
 * Created by devin on 1/24/18.
 * Modified by
 * Purpose : Base view which can be extend to all other views of MVP
 */
public interface MvpView
{
    /**
     * Override to get current context object.
     */
    Context getCurrentContext();

    /**
     * Override to show loader for long running task
     */
    void showLoader(String aMessage);

    /**
     * Override to hide loader of long running task
     */
    void hideLoader();

    /**
     * override to show error message when internet connection is not available
     */
    void noInternetConnection(NetworkRetryCallback mRetryCallback);
}